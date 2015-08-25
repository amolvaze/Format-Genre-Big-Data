import org.apache.commons.lang.ArrayUtils;
import org.apache.pig.EvalFunc;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.Tuple;

@SuppressWarnings("unused")
public class FORMAT_GENRE extends EvalFunc<String> {

	@Override
	public String exec(Tuple input) {
		try {
			if (input == null || input.size() == 0) {
				return null;
			}
			String inpt = (String) input.get(0);
			String[] genre = inpt.split("\\|");
			StringBuilder str = new StringBuilder();

			ArrayUtils.reverse(genre);

			int count = 1;

			int length = genre.length;
			// for (String element : genre) {
			if (length == 1) {
				str.append("1) " + genre[0] + " asv130130");
				return str.toString();

			} else if (length == 2) {
				str.append("1) " + genre[0] + " & 2) " + genre[1]+ " asv130130");
				return str.toString();

			} else if (length == 3)
				str.append("1)" + genre[0] + ", 2)" + genre[1] + " & 3)"
						+ genre[2] + " asv130130");

			return str.toString();

		} catch (Exception ex) {
			System.out.println("Error: " + ex.toString());
		}
		return null;
	}
}