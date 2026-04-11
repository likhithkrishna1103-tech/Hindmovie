package be;

import ae.r;
import ae.s;
import ae.t;
import ae.u;
import ae.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements ge.b, d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f2038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f2039c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f2040a;

    static {
        int i = 0;
        List listS = od.j.S(ae.a.class, ae.l.class, ae.p.class, ae.q.class, a5.a.class, r.class, s.class, t.class, u.class, v.class, ae.b.class, ae.c.class, ae.d.class, ae.e.class, ae.f.class, ae.g.class, ae.h.class, ae.i.class, ae.j.class, ae.k.class, ae.m.class, ae.n.class, ae.o.class);
        ArrayList arrayList = new ArrayList(od.k.U(listS));
        for (Object obj : listS) {
            int i10 = i + 1;
            if (i < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new nd.f((Class) obj, Integer.valueOf(i)));
            i = i10;
        }
        f2038b = od.t.I(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        h.d(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb2 = new StringBuilder("kotlin.jvm.internal.");
            h.b(str);
            sb2.append(ie.e.Z(str, str));
            sb2.append("CompanionObject");
            map3.put(sb2.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f2038b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        f2039c = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(od.t.H(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            h.b(str2);
            linkedHashMap.put(key, ie.e.Z(str2, str2));
        }
    }

    public e(Class cls) {
        h.e(cls, "jClass");
        this.f2040a = cls;
    }

    @Override // be.d
    public final Class a() {
        return this.f2040a;
    }

    public final String b() {
        String str;
        Class cls = this.f2040a;
        h.e(cls, "jClass");
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        boolean zIsArray = cls.isArray();
        HashMap map = f2039c;
        if (!zIsArray) {
            String str2 = (String) map.get(cls.getName());
            return str2 == null ? cls.getCanonicalName() : str2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (str = (String) map.get(componentType.getName())) != null) {
            strConcat = str.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final boolean c(Object obj) {
        Class clsN = this.f2040a;
        h.e(clsN, "jClass");
        Map map = f2038b;
        h.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(clsN);
        if (num != null) {
            return q.b(num.intValue(), obj);
        }
        if (clsN.isPrimitive()) {
            clsN = a.a.n(o.a(clsN));
        }
        return clsN.isInstance(obj);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && a.a.n(this).equals(a.a.n((ge.b) obj));
    }

    public final int hashCode() {
        return a.a.n(this).hashCode();
    }

    public final String toString() {
        return this.f2040a + " (Kotlin reflection is not available)";
    }
}
