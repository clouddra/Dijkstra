class IntegerPair implements Comparable {
  Integer _first, _second;

  public IntegerPair(Integer f, Integer s) {
    _first = f;
    _second = s;
  }

	public int compareTo(Object o) {
		// compare by weight then vertex number
		if (this.second() != ((IntegerPair )o).second())
			return this.second() - ((IntegerPair )o).second();

		return this.first() - ((IntegerPair )o).first();
	}

  Integer second() { return _second; }
  Integer first() { return _first; }
}
