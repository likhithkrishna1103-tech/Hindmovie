package sd;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends n {
    public static void g0(Iterable iterable, AbstractCollection abstractCollection) {
        ge.i.e(iterable, "elements");
        if (iterable instanceof Collection) {
            abstractCollection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static Object h0(List list) {
        ge.i.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object i0(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final void j0(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, fe.l lVar) {
        ge.i.e(iterable, "<this>");
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            u8.a.a(sb, obj, lVar);
        }
        sb.append(charSequence3);
    }

    public static String l0(Iterable iterable, String str, String str2, String str3, fe.l lVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            lVar = null;
        }
        ge.i.e(iterable, "<this>");
        ge.i.e(str5, "prefix");
        StringBuilder sb = new StringBuilder();
        j0(iterable, sb, str4, str5, str6, "...", lVar);
        return sb.toString();
    }

    public static Object m0(List list) {
        ge.i.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(k.d0(list));
    }

    public static Object n0(List list) {
        ge.i.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(k.d0(list));
    }

    public static List o0(AbstractList abstractList) {
        ge.i.e(abstractList, "<this>");
        if (abstractList.size() <= 1) {
            return r0(abstractList);
        }
        Object[] array = abstractList.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        ge.i.e(comparableArr, "<this>");
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return i.a(array);
    }

    public static List p0(Iterable iterable, Comparator comparator) {
        ge.i.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listT0 = t0(iterable);
            if (((ArrayList) listT0).size() > 1) {
                Collections.sort(listT0, comparator);
            }
            return listT0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return r0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        ge.i.e(array, "<this>");
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return i.a(array);
    }

    public static final void q0(Iterable iterable, AbstractCollection abstractCollection) {
        ge.i.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List r0(Iterable iterable) {
        ge.i.e(iterable, "<this>");
        boolean z10 = iterable instanceof Collection;
        p pVar = p.f11669v;
        if (!z10) {
            List listT0 = t0(iterable);
            ArrayList arrayList = (ArrayList) listT0;
            int size = arrayList.size();
            return size != 0 ? size != 1 ? listT0 : n5.a.x(arrayList.get(0)) : pVar;
        }
        Collection collection = (Collection) iterable;
        int size2 = collection.size();
        if (size2 == 0) {
            return pVar;
        }
        if (size2 != 1) {
            return s0(collection);
        }
        return n5.a.x(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static ArrayList s0(Collection collection) {
        ge.i.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final List t0(Iterable iterable) {
        ge.i.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return s0((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        q0(iterable, arrayList);
        return arrayList;
    }

    public static Set u0(Iterable iterable) {
        ge.i.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(s.A(collection.size()));
                    q0(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                Set setSingleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                ge.i.d(setSingleton, "singleton(...)");
                return setSingleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            q0(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set setSingleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                ge.i.d(setSingleton2, "singleton(...)");
                return setSingleton2;
            }
        }
        return r.f11671v;
    }
}
