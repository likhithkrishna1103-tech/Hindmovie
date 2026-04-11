package a0;

import androidx.media3.decoder.DecoderInputBuffer;
import b0.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f22d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f23e;
    public c f;
    public y.f i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet f19a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f24g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25h = Integer.MIN_VALUE;

    public c(d dVar, int i) {
        this.f22d = dVar;
        this.f23e = i;
    }

    public final void a(c cVar, int i) {
        b(cVar, i, Integer.MIN_VALUE, false);
    }

    public final boolean b(c cVar, int i, int i10, boolean z10) {
        if (cVar == null) {
            j();
            return true;
        }
        if (!z10 && !i(cVar)) {
            return false;
        }
        this.f = cVar;
        if (cVar.f19a == null) {
            cVar.f19a = new HashSet();
        }
        HashSet hashSet = this.f.f19a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f24g = i;
        this.f25h = i10;
        return true;
    }

    public final void c(int i, n nVar, ArrayList arrayList) {
        HashSet hashSet = this.f19a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                b0.h.b(((c) it.next()).f22d, i, arrayList, nVar);
            }
        }
    }

    public final int d() {
        if (this.f21c) {
            return this.f20b;
        }
        return 0;
    }

    public final int e() {
        c cVar;
        if (this.f22d.f38g0 == 8) {
            return 0;
        }
        int i = this.f25h;
        return (i == Integer.MIN_VALUE || (cVar = this.f) == null || cVar.f22d.f38g0 != 8) ? this.f24g : i;
    }

    public final c f() {
        int i = this.f23e;
        int iC = y.e.c(i);
        d dVar = this.f22d;
        switch (iC) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return null;
            case 1:
                return dVar.K;
            case 2:
                return dVar.L;
            case 3:
                return dVar.I;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return dVar.J;
            default:
                throw new AssertionError(q4.a.w(i));
        }
    }

    public final boolean g() {
        HashSet hashSet = this.f19a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0063 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(a0.c r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L5
            goto L65
        L5:
            a0.d r1 = r11.f22d
            int r11 = r11.f23e
            r2 = 6
            int r3 = r10.f23e
            r4 = 1
            if (r11 != r3) goto L1c
            if (r3 != r2) goto L63
            boolean r11 = r1.E
            if (r11 == 0) goto L65
            a0.d r11 = r10.f22d
            boolean r11 = r11.E
            if (r11 != 0) goto L63
            goto L65
        L1c:
            int r5 = y.e.c(r3)
            r6 = 4
            r7 = 2
            r8 = 9
            r9 = 8
            switch(r5) {
                case 0: goto L65;
                case 1: goto L53;
                case 2: goto L3f;
                case 3: goto L53;
                case 4: goto L3f;
                case 5: goto L3a;
                case 6: goto L33;
                case 7: goto L65;
                case 8: goto L65;
                default: goto L29;
            }
        L29:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            java.lang.String r0 = q4.a.w(r3)
            r11.<init>(r0)
            throw r11
        L33:
            if (r11 == r2) goto L65
            if (r11 == r9) goto L65
            if (r11 == r8) goto L65
            goto L63
        L3a:
            if (r11 == r7) goto L65
            if (r11 != r6) goto L63
            goto L65
        L3f:
            r2 = 3
            if (r11 == r2) goto L48
            r2 = 5
            if (r11 != r2) goto L46
            goto L48
        L46:
            r2 = r0
            goto L49
        L48:
            r2 = r4
        L49:
            boolean r1 = r1 instanceof a0.h
            if (r1 == 0) goto L52
            if (r2 != 0) goto L63
            if (r11 != r8) goto L65
            goto L63
        L52:
            return r2
        L53:
            if (r11 == r7) goto L5a
            if (r11 != r6) goto L58
            goto L5a
        L58:
            r2 = r0
            goto L5b
        L5a:
            r2 = r4
        L5b:
            boolean r1 = r1 instanceof a0.h
            if (r1 == 0) goto L64
            if (r2 != 0) goto L63
            if (r11 != r9) goto L65
        L63:
            return r4
        L64:
            return r2
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.c.i(a0.c):boolean");
    }

    public final void j() {
        HashSet hashSet;
        c cVar = this.f;
        if (cVar != null && (hashSet = cVar.f19a) != null) {
            hashSet.remove(this);
            if (this.f.f19a.size() == 0) {
                this.f.f19a = null;
            }
        }
        this.f19a = null;
        this.f = null;
        this.f24g = 0;
        this.f25h = Integer.MIN_VALUE;
        this.f21c = false;
        this.f20b = 0;
    }

    public final void k() {
        y.f fVar = this.i;
        if (fVar == null) {
            this.i = new y.f(1);
        } else {
            fVar.c();
        }
    }

    public final void l(int i) {
        this.f20b = i;
        this.f21c = true;
    }

    public final String toString() {
        return this.f22d.f40h0 + ":" + q4.a.w(this.f23e);
    }
}
