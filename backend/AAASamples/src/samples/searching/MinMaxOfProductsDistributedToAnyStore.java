package samples.searching;

public class MinMaxOfProductsDistributedToAnyStore {
	/*
	 * You are given an integer n indicating there are n specialty retail stores.
	 * There are m product types of varying amounts, which are given as a 0-indexed
	 * integer array quantities, where quantities[i] represents the number of
	 * products of the ith product type.
	 * 
	 * You need to distribute all products to the retail stores following these
	 * rules:
	 * 
	 * A store can only be given at most one product type but can be given any
	 * amount of it. After distribution, each store will have been given some number
	 * of products (possibly 0). Let x represent the maximum number of products
	 * given to any store. You want x to be as small as possible, i.e., you want to
	 * minimize the maximum number of products that are given to any store. Return
	 * the minimum possible x
	 * 
	 * Input: n = 6, quantities = [11,6] Output: 3
	 * 
	 * Explanation: One optimal way is: - The 11 products of type 0 are distributed
	 * to the first four stores in these amounts: 2, 3, 3, 3 - The 6 products of
	 * type 1 are distributed to the other two stores in these amounts: 3, 3 The
	 * maximum number of products given to any store is max(2, 3, 3, 3, 3, 3) = 3.
	 * 
	 * Almost same as koko eating banana, here canEat is changed to canDistribute
	 */
	
	public static boolean canDistribute(int[] q, int storeLimit, int mid) {
		long reqdStores = 0;
		for(int i=0;i<q.length;i++) {
			reqdStores = reqdStores + (long)(q[i]+mid-1)/mid; //OR (long) Math.ceil((double) quantities[i] / mid)
		}
		return reqdStores<=storeLimit;
	}
	public static int minimizedMaximum(int n, int[] quantities) {
		int lo=1;
		int hi=1;
		for(int i=0;i<quantities.length;i++) {
			hi = Math.max(hi, quantities[i]);
		}
		while(lo<=hi) {
			int mid = (lo+hi)/2; //lo+(hi-lo)/2;
			if(canDistribute(quantities,n,mid)) {
				hi=mid-1;
			}else {
				lo=mid+1;
			}
		}
		return lo;
	}

	public static void main(String[] args) {
		int n = 7;
		int[] quantities = { 15, 10, 10 };
		System.out.println(minimizedMaximum(n, quantities));
	}
}
