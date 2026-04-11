package hb;

import com.google.android.gms.internal.measurement.z3;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f5877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f5878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5880e;
    public final e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f5881g;

    public b(String str, Set set, Set set2, int i, int i10, e eVar, Set set3) {
        this.f5876a = str;
        this.f5877b = Collections.unmodifiableSet(set);
        this.f5878c = Collections.unmodifiableSet(set2);
        this.f5879d = i;
        this.f5880e = i10;
        this.f = eVar;
        this.f5881g = Collections.unmodifiableSet(set3);
    }

    public static a a(r rVar) {
        r[] rVarArr = new r[0];
        a aVar = new a();
        aVar.f5870a = null;
        HashSet hashSet = new HashSet();
        aVar.f5873d = hashSet;
        aVar.f5874e = new HashSet();
        aVar.f5871b = 0;
        aVar.f5872c = 0;
        aVar.f = new HashSet();
        hashSet.add(rVar);
        for (r rVar2 : rVarArr) {
            z3.h(rVar2, "Null interface");
        }
        Collections.addAll((HashSet) aVar.f5873d, rVarArr);
        return aVar;
    }

    public static a b(Class cls) {
        return new a(cls, new Class[0]);
    }

    public static b c(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(r.a(cls));
        for (Class cls2 : clsArr) {
            z3.h(cls2, "Null interface");
            hashSet.add(r.a(cls2));
        }
        return new b(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new h2.d(obj), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f5877b.toArray()) + ">{" + this.f5879d + ", type=" + this.f5880e + ", deps=" + Arrays.toString(this.f5878c.toArray()) + "}";
    }
}
