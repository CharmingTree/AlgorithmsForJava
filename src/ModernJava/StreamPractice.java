package ModernJava;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ModernJava.Domain.Trader;
import ModernJava.Domain.Transaction;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamPractice {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(brian, 2011, 100),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
		// quiz#1 : 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
		List<Transaction> result1 = transactions.stream().filter(s->s.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList());
		System.out.println(result1);
		
		// quiz#2 : 거래자가 근무하는 모든 도시를 중복 없이 나열하시오. 
		List<String> citys = transactions.stream().map(t->t.getTrader().getCity()).distinct().collect(toList());
		System.out.println(citys);
		
		// quiz#3 : 케임브릿지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오. 
		List<Trader> result2 = transactions.stream()
				.map(Transaction::getTrader)
				.filter(t->t.getCity().equals("Cambridge")).distinct().sorted(comparing(Trader::getName)).collect(toList());
		System.out.println(result2);
		
		// quiz#4 : 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
		//List<String> names = transactions.stream().map(t->t.getTrader().getName()).sorted(comparing(Trader::getName)).collect(toList()); // 오답
		String traderStr = transactions.stream().map(t->t.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("", (n1,n2)->n1+", "+n2);
		System.out.println(traderStr); // 비효율적
		
		traderStr = transactions.stream()
				.map(t->t.getTrader().getName())
				.distinct()
				.sorted()
				.collect(joining()); // joining은 내부적으로 StringBuilder 를 이용함 
		
		System.out.println(traderStr);
		
		// quiz#5 : 밀라노에 거래자가 있는가?
		boolean isMilan = transactions.stream().anyMatch(t->t.getTrader().getCity().equals("Milan"));
		System.out.println(isMilan);
		
		// quiz#6 : 케임브리지에서 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
		int camSum = transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).map(v->v.getValue()).reduce(0, Integer::sum);
		System.out.println(camSum);
		
		// quiz#7 : 전체 트랜잭션 중 최대값은 얼마인가?
		int maxValue = transactions.stream().map(Transaction::getValue).reduce(0 , Integer::max);
		System.out.println(maxValue);
		
		// quiz#8 : 전체 트랜잭션 중 최소값은 얼마인가?
		Optional<Integer> minValue = transactions.stream().map(Transaction::getValue).reduce(Integer::min); // or
		Optional<Transaction> minTransaction = transactions.stream().min(comparing(Transaction::getValue));
		System.out.println(minValue);
		System.out.println(minTransaction);
	}

}
