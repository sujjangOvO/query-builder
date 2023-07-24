package Builder.where;

import java.util.List;

public class Where {
	private List<Condition> conditions;

	public Where(List<Condition> conditions) {
		this.conditions = conditions;
	}

	@Override
	public String toString() {
		String str = "";
		for(Condition c : conditions) {
			str += c.toString();
		}
		return str;
	}
}
