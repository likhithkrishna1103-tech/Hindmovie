package hb;

import com.google.android.gms.internal.measurement.z3;
import java.io.Serializable;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Serializable f5874e;
    public Serializable f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f5875g;

    public a(Class cls, Class[] clsArr) {
        HashSet hashSet = new HashSet();
        this.f5873d = hashSet;
        this.f5874e = new HashSet();
        this.f5871b = 0;
        this.f5872c = 0;
        this.f = new HashSet();
        hashSet.add(r.a(cls));
        for (Class cls2 : clsArr) {
            z3.h(cls2, "Null interface");
            ((HashSet) this.f5873d).add(r.a(cls2));
        }
    }

    public void a(j jVar) {
        if (((HashSet) this.f5873d).contains(jVar.f5895a)) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        ((HashSet) this.f5874e).add(jVar);
    }

    public b b() {
        if (((e) this.f5875g) != null) {
            return new b(this.f5870a, new HashSet((HashSet) this.f5873d), new HashSet((HashSet) this.f5874e), this.f5871b, this.f5872c, (e) this.f5875g, (HashSet) this.f);
        }
        throw new IllegalStateException("Missing required property: factory.");
    }

    public void c(int i) {
        if (!(this.f5871b == 0)) {
            throw new IllegalStateException("Instantiation type has already been set.");
        }
        this.f5871b = i;
    }
}
