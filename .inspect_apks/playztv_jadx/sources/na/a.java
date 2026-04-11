package na;

import java.io.Serializable;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f8876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Serializable f8877e;
    public Serializable f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f8878g;

    public a(Class cls, Class[] clsArr) {
        HashSet hashSet = new HashSet();
        this.f8876d = hashSet;
        this.f8877e = new HashSet();
        this.f8874b = 0;
        this.f8875c = 0;
        this.f = new HashSet();
        hashSet.add(r.a(cls));
        for (Class cls2 : clsArr) {
            cf.l.i(cls2, "Null interface");
            ((HashSet) this.f8876d).add(r.a(cls2));
        }
    }

    public void a(j jVar) {
        if (((HashSet) this.f8876d).contains(jVar.f8899a)) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        ((HashSet) this.f8877e).add(jVar);
    }

    public b b() {
        if (((e) this.f8878g) != null) {
            return new b(this.f8873a, new HashSet((HashSet) this.f8876d), new HashSet((HashSet) this.f8877e), this.f8874b, this.f8875c, (e) this.f8878g, (HashSet) this.f);
        }
        throw new IllegalStateException("Missing required property: factory.");
    }

    public void c(int i) {
        if (!(this.f8874b == 0)) {
            throw new IllegalStateException("Instantiation type has already been set.");
        }
        this.f8874b = i;
    }
}
