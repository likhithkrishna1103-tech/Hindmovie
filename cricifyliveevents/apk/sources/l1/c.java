package l1;

import android.os.Build;
import android.view.View;
import f9.b0;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;
import t0.m0;
import td.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7624v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7625w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f7626x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f7627y;

    public c() {
        if (b0.H == null) {
            b0.H = new b0(15);
        }
    }

    public int a(int i) {
        if (i < this.f7626x) {
            return ((ByteBuffer) this.f7627y).getShort(this.f7625w + i);
        }
        return 0;
    }

    public void b() {
        if (((f) this.f7627y).C != this.f7626x) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object c(View view);

    public abstract void d(View view, Object obj);

    public void e() {
        while (true) {
            int i = this.f7624v;
            f fVar = (f) this.f7627y;
            if (i >= fVar.A || fVar.f12008x[i] >= 0) {
                return;
            } else {
                this.f7624v = i + 1;
            }
        }
    }

    public void f(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.f7625w) {
            d(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f7625w) {
            tag = c(view);
        } else {
            tag = view.getTag(this.f7624v);
            if (!((Class) this.f7627y).isInstance(tag)) {
                tag = null;
            }
        }
        if (g(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateD = m0.d(view);
            t0.b bVar = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof t0.a ? ((t0.a) accessibilityDelegateD).f11723a : new t0.b(accessibilityDelegateD);
            if (bVar == null) {
                bVar = new t0.b();
            }
            m0.n(view, bVar);
            view.setTag(this.f7624v, obj);
            m0.h(view, this.f7626x);
        }
    }

    public abstract boolean g(Object obj, Object obj2);

    public boolean hasNext() {
        return this.f7624v < ((f) this.f7627y).A;
    }

    public void remove() {
        f fVar = (f) this.f7627y;
        b();
        if (this.f7625w == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        fVar.c();
        fVar.l(this.f7625w);
        this.f7625w = -1;
        this.f7626x = fVar.C;
    }
}
