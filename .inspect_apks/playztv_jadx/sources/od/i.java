package od;

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
public abstract class i extends o {
    public static ArrayList W(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object X(List list) {
        be.h.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object Y(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final void Z(Iterable iterable, StringBuilder sb2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, ae.l lVar) {
        be.h.e(iterable, "<this>");
        sb2.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb2.append(charSequence);
            }
            cf.l.b(sb2, obj, lVar);
        }
        sb2.append(charSequence3);
    }

    public static String b0(Iterable iterable, String str, String str2, String str3, ae.l lVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            lVar = null;
        }
        be.h.e(iterable, "<this>");
        StringBuilder sb2 = new StringBuilder();
        Z(iterable, sb2, str4, str5, str6, "...", lVar);
        return sb2.toString();
    }

    public static Object c0(List list) {
        be.h.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(j.R(list));
    }

    public static ArrayList d0(Collection collection, Object obj) {
        be.h.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static List e0(AbstractList abstractList) {
        be.h.e(abstractList, "<this>");
        if (abstractList.size() <= 1) {
            return h0(abstractList);
        }
        Object[] array = abstractList.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        be.h.e(comparableArr, "<this>");
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return h.Q(array);
    }

    public static List f0(Iterable iterable, Comparator comparator) {
        be.h.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listI0 = i0(iterable);
            if (((ArrayList) listI0).size() > 1) {
                Collections.sort(listI0, comparator);
            }
            return listI0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return h0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        be.h.e(array, "<this>");
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return h.Q(array);
    }

    public static final void g0(Iterable iterable, AbstractCollection abstractCollection) {
        be.h.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List h0(Iterable iterable) {
        be.h.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return j.T(i0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return q.f9570u;
        }
        if (size != 1) {
            return new ArrayList(collection);
        }
        return android.support.v4.media.session.b.G(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List i0(Iterable iterable) {
        be.h.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        g0(iterable, arrayList);
        return arrayList;
    }

    public static Set j0(Iterable iterable) {
        be.h.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(t.H(collection.size()));
                    g0(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                Set setSingleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                be.h.d(setSingleton, "singleton(...)");
                return setSingleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            g0(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set setSingleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                be.h.d(setSingleton2, "singleton(...)");
                return setSingleton2;
            }
        }
        return s.f9572u;
    }
}
