package f1;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;
import pd.f;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4691u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4692v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4693w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f4694x;

    public c() {
        if (pa.b.f10298v == null) {
            pa.b.f10298v = new pa.b(10);
        }
    }

    public int a(int i) {
        if (i < this.f4693w) {
            return ((ByteBuffer) this.f4694x).getShort(this.f4692v + i);
        }
        return 0;
    }

    public void b() {
        if (((f) this.f4694x).B != this.f4693w) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object c(View view);

    public abstract void d(View view, Object obj);

    public void e() {
        while (true) {
            int i = this.f4691u;
            f fVar = (f) this.f4694x;
            if (i >= fVar.f10359z || fVar.f10356w[i] >= 0) {
                return;
            } else {
                this.f4691u = i + 1;
            }
        }
    }

    public void f(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.f4692v) {
            d(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f4692v) {
            tag = c(view);
        } else {
            tag = view.getTag(this.f4691u);
            if (!((Class) this.f4694x).isInstance(tag)) {
                tag = null;
            }
        }
        if (g(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateD = o0.d(view);
            q0.b bVar = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof q0.a ? ((q0.a) accessibilityDelegateD).f10412a : new q0.b(accessibilityDelegateD);
            if (bVar == null) {
                bVar = new q0.b();
            }
            o0.n(view, bVar);
            view.setTag(this.f4691u, obj);
            o0.h(view, this.f4693w);
        }
    }

    public abstract boolean g(Object obj, Object obj2);

    public boolean hasNext() {
        return this.f4691u < ((f) this.f4694x).f10359z;
    }

    public void remove() {
        f fVar = (f) this.f4694x;
        b();
        if (this.f4692v == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        fVar.b();
        fVar.k(this.f4692v);
        this.f4692v = -1;
        this.f4693w = fVar.B;
    }
}
