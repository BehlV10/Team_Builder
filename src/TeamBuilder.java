public class TeamBuilder {
	
	public int[] specialLocations(String[] paths) {
		final int n = paths.length;
		boolean[][] reachable = new boolean[n][n]; //create adjacency matrix
		boolean temp = true; //Temporary boolean for adjacency matrix
		int reaching_locs = 0; //# of locations that can reach all other locations
		int reachable_locs = 0; //# of locations that can be reached by all other locations
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				try {
					if (paths[i].charAt(j) == '1') reachable[i][j] = true;
				}
				catch (IndexOutOfBoundsException e) {
				    //System.err.println("IndexOutOfBoundsException: " + e.getMessage());
				    //System.out.println("The numbers given are malformed!");
				    return null; //Return null if input is incorrect
				}
			}
		reachable[i][i] = true; //Can reach itself
		}
		
		while (temp) {
			temp = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						//If there's an indirect path, there is a path - repeat until no more indirect paths
						if (reachable[i][j] && reachable[j][k] && !reachable[i][k]) {
							reachable[i][k] = true;
							temp = true;
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			boolean first = true;
			boolean second = true;
			for (int j = 0; j < n; j++) {
				if (!reachable[i][j]) {
					first = false;
				}
				if (!reachable[j][i]) {
					second = false;
				}
			}
			if (first) reaching_locs++;
			if (second) reachable_locs++;
		}
		return new int[] {reaching_locs, reachable_locs};
	}
}