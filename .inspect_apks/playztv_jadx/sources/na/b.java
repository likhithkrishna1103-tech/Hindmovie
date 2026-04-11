package na;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f8880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f8881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8883e;
    public final e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f8884g;

    public b(String str, Set set, Set set2, int i, int i10, e eVar, Set set3) {
        this.f8879a = str;
        this.f8880b = Collections.unmodifiableSet(set);
        this.f8881c = Collections.unmodifiableSet(set2);
        this.f8882d = i;
        this.f8883e = i10;
        this.f = eVar;
        this.f8884g = Collections.unmodifiableSet(set3);
    }

    public static a a(Class cls) {
        return new a(cls, new Class[0]);
    }

    public static a b(r rVar) {
        r[] rVarArr = new r[0];
        a aVar = new a();
        aVar.f8873a = null;
        HashSet hashSet = new HashSet();
        aVar.f8876d = hashSet;
        aVar.f8877e = new HashSet();
        aVar.f8874b = 0;
        aVar.f8875c = 0;
        aVar.f = new HashSet();
        hashSet.add(rVar);
        for (r rVar2 : rVarArr) {
            cf.l.i(rVar2, "Null interface");
        }
        Collections.addAll((HashSet) aVar.f8876d, rVarArr);
        return aVar;
    }

    public static b c(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(r.a(cls));
        for (Class cls2 : clsArr) {
            cf.l.i(cls2, "Null interface");
            hashSet.add(r.a(cls2));
        }
        return new b(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new b2.e(obj), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f8880b.toArray()) + ">{" + this.f8882d + ", type=" + this.f8883e + ", deps=" + Arrays.toString(this.f8881c.toArray()) + "}";
    }
}
