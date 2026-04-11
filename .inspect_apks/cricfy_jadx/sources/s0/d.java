package s0;

import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object[] f11144v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11145w;

    public d(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f11144v = new Object[i];
    }

    public void a(y.b bVar) {
        int i = this.f11145w;
        Object[] objArr = this.f11144v;
        if (i < objArr.length) {
            objArr[i] = bVar;
            this.f11145w = i + 1;
        }
    }

    @Override // s0.c
    public boolean b(Object obj) {
        Object[] objArr;
        boolean z10;
        i.e(obj, "instance");
        int i = this.f11145w;
        int i10 = 0;
        while (true) {
            objArr = this.f11144v;
            if (i10 >= i) {
                z10 = false;
                break;
            }
            if (objArr[i10] == obj) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i11 = this.f11145w;
        if (i11 >= objArr.length) {
            return false;
        }
        objArr[i11] = obj;
        this.f11145w = i11 + 1;
        return true;
    }

    @Override // s0.c
    public Object i() {
        int i = this.f11145w;
        if (i <= 0) {
            return null;
        }
        int i10 = i - 1;
        Object[] objArr = this.f11144v;
        Object obj = objArr[i10];
        i.c(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        objArr[i10] = null;
        this.f11145w--;
        return obj;
    }

    public d() {
        this.f11144v = new Object[256];
    }
}
