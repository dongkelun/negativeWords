package zx.soft.dkl;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import zx.soft.words.dao.CategoriesMapper;
import zx.soft.words.dao.WordsMapper;
import zx.soft.words.model.Categories;
import zx.soft.words.model.Words;

public class test {
	private static final String LEI_ROUTE = "/home/dkl/lei.txt";
	public static final int ONE_M = 1024;

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("mybatis-config.xml"));
		try (SqlSession session = sqlSessionFactory.openSession(true);) {
			CategoriesMapper userDaoMapper = session
					.getMapper(CategoriesMapper.class);
			WordsMapper mapper = session.getMapper(WordsMapper.class);
			try {
				String lei[] = inputTest(LEI_ROUTE);
				// System.out.println(lei[2]);

				// System.out.println(lei.length);
				for (int i = 0; i < lei.length - 1; i++) {
					System.out.println(lei[i]);
					Words words = new Words(17278 + i, 24, lei[i], 29);
					mapper.addWords(words);
					// Categories categories = new Categories(24, "政治安全", "安庆");
					// userDaoMapper.addCategoory(categories);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			// userDaoMapper.addCategoory(categories2);
			// List<Categories> categories = userDaoMapper.getCategories("合肥");
			// System.out.println(categories);
		}
	}

	private static String[] inputTest(String route) throws IOException {
		int i = 0;
		FileInputStream fin = new FileInputStream(route);
		FileChannel fc = fin.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(ONE_M);
		fc.read(buffer);
		buffer.flip();
		byte[] array = buffer.array();
		String s[] = new String(array).toString().split("  ");
		fc.close();
		fin.close();

		return s;
	}

}
