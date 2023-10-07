
class RandomizedCollection {
    HashMap<Integer, Set<Integer>> map;
    List<Integer> list = new ArrayList<>();
    Random r;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        boolean flag;
        Set<Integer> set;
        if (map.containsKey(val)) {
            set = map.get(val);
            flag = false;
        } else {
            set = new HashSet<>();
            flag = true;
        }

        set.add(list.size());
        list.add(val);
        map.put(val, set);
        return flag;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Set<Integer> set = map.get(val);
            if (set.isEmpty()) {
                return false;
            }

            int remidx = set.iterator().next();
            set.remove(remidx);

            if (remidx == list.size() - 1) {
                list.remove(list.size() - 1);
            } else {
                int lastVal = list.get(list.size() - 1);
                list.set(remidx, lastVal);
                list.remove(list.size() - 1);

                Set<Integer> lastValSet = map.get(lastVal);
                lastValSet.remove(list.size());

                if (remidx != list.size()) {
                    lastValSet.add(remidx);
                }
            }

            if (set.isEmpty()) {
                map.remove(val);
            }

            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int randIdx = r.nextInt(list.size());
        return list.get(randIdx);
    }
}
