package ta_lab_7;

import java.util.ArrayList;

public class HashStructure {

	private ArrayList<ArrayList<Pair>> arr;
	private int size;

	public HashStructure(int size) {
		super();
		this.size = size;
		arr = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < size; ++i) {
			this.arr.add(new ArrayList<Pair>());
		}

	}

	public void insert(Pair p) {
		int h = hash(p.key) % size;

		@SuppressWarnings("unchecked")
		ArrayList<Pair> l = (ArrayList<Pair>) this.arr.get(h).clone();
		l.add(p);
		this.arr.set(h, l);

	}

	public Pair search(String key) {
		int h = hash(key) % size;
		@SuppressWarnings("unchecked")
		ArrayList<Pair> a = (ArrayList<Pair>) arr.get(h).clone();
		sort(a);
		int position = binarySearch(a, key);
		if (position != -1)
			return a.get(position);
		return null;
	}

	static private void sort(ArrayList<Pair> arr) {
		int n = arr.size();
		for (int i = 1; i < n; ++i) {
			String key = arr.get(i).key;
			String value = arr.get(i).value;
			int j = i - 1;

			while (j >= 0 && arr.get(j).key.compareTo(key) > 0) {
				arr.set(j + 1, arr.get(j));
				j = j - 1;
			}
			arr.set(j + 1, new Pair(key, value));
		}
	}

	static private int binarySearch(ArrayList<Pair> arr, String key) {
		int low = 0;
		int high = arr.size() - 1;
		int counter = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			counter++;
			if (arr.get(mid).key.compareTo(key) == 0) {
				System.out.println(counter);
				return mid;
			}

			else if (arr.get(mid).key.compareTo(key) < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		System.out.println(counter);
		return -1;
	}

	public int size() {
		return size;
	}

	static int hash(String key) {
		int hash = 0;

		for (int i = 0; i < key.length(); ++i) {
			hash += key.charAt(i);
			hash += (hash << 10);
			hash ^= (hash >> 6);
		}
		hash += (hash << 3);
		hash ^= (hash >> 11);
		hash += (hash << 15);
		return (hash < 0) ? -hash : hash;
	}

	void print() {
		for (var e : arr) {
			if (e.isEmpty())
				continue;
			else {
				for (var i : e) {
					System.out.println(hash(i.key) % size + " " + i.key + " " + i.value);
				}
			}
		}
	}
}
