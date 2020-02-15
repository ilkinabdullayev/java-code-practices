package info.ilkinabdullayev.mooc.crap1;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        final int a = 3;

        Xiyar xiyar = new Xiyar() {
            @Override
            public List<String> get() {
                //a
                return Collections.emptyList();
            }
        };


        SuperXiyar superXiyar = SuperSpagetti::new;
        ToIntFunction<String> s = Integer::new;
    }

    private void test2() {
        IntFunction<String> intFunction = Integer::toString;

        // will not compile because, there are 2 matches for method references. arbitary and static
        // Function<Integer, String> integerStringFunction = Integer::toString;
        Function<Integer, String> integerStringFunction = Object::toString;

        // will not compile because, there are 2 matches for method references. arbitary and static
        // Function<Spaggetti, String> aboshQuluStringFunction = Spaggetti::toString;


        Function<Integer, int[]> arrayFactory = int[]::new;
        Function<Integer, Spaggetti> spagettiFactory = Spaggetti::new;

        int[] arr = arrayFactory.apply(2);
        Spaggetti spaggetti = spagettiFactory.apply(2);

        Xiyar xiyar = () -> new ArrayList<>();
        xiyar = ArrayList::new;
    }

    private void test1() {
        List<String> ls = Arrays.asList("How", "Are", "You", "World");
        ls.stream().peek(p -> p.toString()).forEach(System.out::println);

        List<Super> lsSuper = Arrays.asList(
                new Super("s1"),
                new Super("s2")
        );


        Perfecto perfecto = new Perfecto() {
            @Override
            public void validateRequest(Request request, Map<String, String> map) {
                request.printHeader(map);
            }
        };

        Map<String, String> map = new HashMap<>();
        map.put("H1", "Test");

        perfecto.validateRequest(new Request(), Collections.unmodifiableMap(map));
        /////////////////////
        perfecto = (req, map1) -> {
            req.printHeader(map1);
        };

        perfecto.validateRequest(new Request(), Collections.unmodifiableMap(map));
        ////////////////////////////////
        perfecto = Request::printHeader;
        perfecto.validateRequest(new Request(), Collections.unmodifiableMap(map));

        Supplier<int[]> arrSup = () -> new int[2];

        LongToDoubleFunction longToDoubleFunction = l -> (double) l;
        longToDoubleFunction.applyAsDouble(3);
    }

}

interface SuperXiyar {
    SuperSpagetti test(int a, String b, long c);
}

class SuperSpagetti {
    int a;
    String b;
    long c;

    public SuperSpagetti(int a, String b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

class Spaggetti {
    private int length;

    public Spaggetti(int length) {
        this.length = length;
    }

    public String toString() {
        return "";
    }

    public static String toString(Spaggetti a) {
        return a + "";
    }
}

interface Xiyar {
    List<String> get();
}

@FunctionalInterface
interface Perfecto {

    void validateRequest(Request request, Map<String, String> map);

}

class Request {
    void printHeader(Map<String, String> map) {
        map.forEach((k, v) -> {
            System.out.println("Key:" + k + "; Value:" + v);
        });
    }
}

class Super {
    private String text;

    public Super(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
