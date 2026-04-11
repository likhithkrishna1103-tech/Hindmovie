package p0;

import be.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object[] f9607u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f9608v;

    public d(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f9607u = new Object[i];
    }

    public void a(v.b bVar) {
        int i = this.f9608v;
        Object[] objArr = this.f9607u;
        if (i < objArr.length) {
            objArr[i] = bVar;
            this.f9608v = i + 1;
        }
    }

    @Override // p0.c
    public boolean b(Object obj) {
        Object[] objArr;
        boolean z2;
        h.e(obj, "instance");
        int i = this.f9608v;
        int i10 = 0;
        while (true) {
            objArr = this.f9607u;
            if (i10 >= i) {
                z2 = false;
                break;
            }
            if (objArr[i10] == obj) {
                z2 = true;
                break;
            }
            i10++;
        }
        if (z2) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i11 = this.f9608v;
        if (i11 >= objArr.length) {
            return false;
        }
        objArr[i11] = obj;
        this.f9608v = i11 + 1;
        return true;
    }

    @Override // p0.c
    public Object i() {
        int i = this.f9608v;
        if (i <= 0) {
            return null;
        }
        int i10 = i - 1;
        Object[] objArr = this.f9607u;
        Object obj = objArr[i10];
        h.c(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        objArr[i10] = null;
        this.f9608v--;
        return obj;
    }

    public d() {
        this.f9607u = new Object[256];
    }
}
