package z9;

import aa.l0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Iterator {
    public final /* synthetic */ q0.e A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f14912v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CharSequence f14913w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f14914x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f14916z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14911u = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14915y = 0;

    public k(q0.e eVar, l0 l0Var, CharSequence charSequence) {
        this.A = eVar;
        this.f14914x = (b) l0Var.f706w;
        this.f14916z = l0Var.f705v;
        this.f14913w = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String string;
        b bVar;
        int i = this.f14911u;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int iC = v.e.c(i);
        if (iC == 0) {
            return true;
        }
        if (iC == 2) {
            return false;
        }
        this.f14911u = 4;
        int i10 = this.f14915y;
        while (true) {
            int length = this.f14915y;
            if (length == -1) {
                this.f14911u = 3;
                string = null;
                break;
            }
            c cVar = (c) this.A.f10436v;
            CharSequence charSequence = this.f14913w;
            int length2 = charSequence.length();
            q1.c.k(length, length2);
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (cVar.a(charSequence.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = charSequence.length();
                this.f14915y = -1;
            } else {
                this.f14915y = length + 1;
            }
            int i11 = this.f14915y;
            if (i11 == i10) {
                int i12 = i11 + 1;
                this.f14915y = i12;
                if (i12 > charSequence.length()) {
                    this.f14915y = -1;
                }
            } else {
                while (true) {
                    bVar = this.f14914x;
                    if (i10 >= length || !bVar.a(charSequence.charAt(i10))) {
                        break;
                    }
                    i10++;
                }
                while (length > i10 && bVar.a(charSequence.charAt(length - 1))) {
                    length--;
                }
                int i13 = this.f14916z;
                if (i13 == 1) {
                    length = charSequence.length();
                    this.f14915y = -1;
                    while (length > i10 && bVar.a(charSequence.charAt(length - 1))) {
                        length--;
                    }
                } else {
                    this.f14916z = i13 - 1;
                }
                string = charSequence.subSequence(i10, length).toString();
            }
        }
        this.f14912v = string;
        if (this.f14911u == 3) {
            return false;
        }
        this.f14911u = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f14911u = 2;
        String str = this.f14912v;
        this.f14912v = null;
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
