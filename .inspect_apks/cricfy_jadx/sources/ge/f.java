package ge;

import fe.t;
import fe.u;
import fe.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements le.b, e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f5247b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f5248a;

    static {
        int i = 0;
        List listA = sd.i.a(new Class[]{fe.a.class, fe.l.class, fe.p.class, fe.q.class, e5.a.class, fe.r.class, fe.s.class, t.class, u.class, v.class, fe.b.class, fe.c.class, fe.d.class, fe.e.class, fe.f.class, fe.g.class, fe.h.class, fe.i.class, fe.j.class, fe.k.class, fe.m.class, fe.n.class, fe.o.class});
        ArrayList arrayList = new ArrayList(sd.l.f0(listA, 10));
        for (Object obj : listA) {
            int i10 = i + 1;
            if (i < 0) {
                sd.k.e0();
                throw null;
            }
            arrayList.add(new rd.f((Class) obj, Integer.valueOf(i)));
            i = i10;
        }
        f5247b = sd.s.B(arrayList);
    }

    public f(Class cls) {
        i.e(cls, "jClass");
        this.f5248a = cls;
    }

    @Override // ge.e
    public final Class a() {
        return this.f5248a;
    }

    public final String b() {
        String strB;
        Class cls = this.f5248a;
        i.e(cls, "jClass");
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        if (!cls.isArray()) {
            String strB2 = s.b(cls.getName());
            return strB2 == null ? cls.getCanonicalName() : strB2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (strB = s.b(componentType.getName())) != null) {
            strConcat = strB.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final String c() {
        String strD;
        Class cls = this.f5248a;
        i.e(cls, "jClass");
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String strD2 = s.d(cls.getName());
                return strD2 == null ? cls.getSimpleName() : strD2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (strD = s.d(componentType.getName())) != null) {
                strConcat = strD.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return ne.h.q0(simpleName, enclosingMethod.getName() + '$', simpleName);
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor != null) {
            return ne.h.q0(simpleName, enclosingConstructor.getName() + '$', simpleName);
        }
        int iH0 = ne.h.h0(simpleName, '$', 0, 6);
        if (iH0 == -1) {
            return simpleName;
        }
        String strSubstring = simpleName.substring(iH0 + 1, simpleName.length());
        i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean d(Object obj) {
        Class clsO = this.f5248a;
        i.e(clsO, "jClass");
        Map map = f5247b;
        i.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(clsO);
        if (num != null) {
            return s.c(num.intValue(), obj);
        }
        if (clsO.isPrimitive()) {
            clsO = n5.a.o(q.a(clsO));
        }
        return clsO.isInstance(obj);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof f) && n5.a.o(this).equals(n5.a.o((le.b) obj));
    }

    public final int hashCode() {
        return n5.a.o(this).hashCode();
    }

    public final String toString() {
        return this.f5248a.toString() + " (Kotlin reflection is not available)";
    }
}
