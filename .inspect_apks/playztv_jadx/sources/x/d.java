package x;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import y.n;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f14117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14118e;
    public d f;
    public v.f i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet f14114a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14119g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14120h = Integer.MIN_VALUE;

    public d(e eVar, int i) {
        this.f14117d = eVar;
        this.f14118e = i;
    }

    public final void a(d dVar, int i) {
        b(dVar, i, Integer.MIN_VALUE, false);
    }

    public final boolean b(d dVar, int i, int i10, boolean z2) {
        if (dVar == null) {
            j();
            return true;
        }
        if (!z2 && !i(dVar)) {
            return false;
        }
        this.f = dVar;
        if (dVar.f14114a == null) {
            dVar.f14114a = new HashSet();
        }
        HashSet hashSet = this.f.f14114a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f14119g = i;
        this.f14120h = i10;
        return true;
    }

    public final void c(int i, ArrayList arrayList, n nVar) {
        HashSet hashSet = this.f14114a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                y.h.b(((d) it.next()).f14117d, i, arrayList, nVar);
            }
        }
    }

    public final int d() {
        if (this.f14116c) {
            return this.f14115b;
        }
        return 0;
    }

    public final int e() {
        d dVar;
        if (this.f14117d.f14133g0 == 8) {
            return 0;
        }
        int i = this.f14120h;
        return (i == Integer.MIN_VALUE || (dVar = this.f) == null || dVar.f14117d.f14133g0 != 8) ? this.f14119g : i;
    }

    public final d f() {
        int i = this.f14118e;
        int iC = v.e.c(i);
        e eVar = this.f14117d;
        switch (iC) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
            case 8:
                return null;
            case 1:
                return eVar.K;
            case 2:
                return eVar.L;
            case 3:
                return eVar.I;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return eVar.J;
            default:
                throw new AssertionError(c.c(i));
        }
    }

    public final boolean g() {
        HashSet hashSet = this.f14114a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).f().h()) {
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
    public final boolean i(x.d r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L5
            goto L65
        L5:
            x.e r1 = r11.f14117d
            int r11 = r11.f14118e
            r2 = 6
            int r3 = r10.f14118e
            r4 = 1
            if (r11 != r3) goto L1c
            if (r3 != r2) goto L63
            boolean r11 = r1.E
            if (r11 == 0) goto L65
            x.e r11 = r10.f14117d
            boolean r11 = r11.E
            if (r11 != 0) goto L63
            goto L65
        L1c:
            int r5 = v.e.c(r3)
            r6 = 8
            r7 = 9
            r8 = 4
            r9 = 2
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
            java.lang.String r0 = x.c.c(r3)
            r11.<init>(r0)
            throw r11
        L33:
            if (r11 == r2) goto L65
            if (r11 == r6) goto L65
            if (r11 == r7) goto L65
            goto L63
        L3a:
            if (r11 == r9) goto L65
            if (r11 != r8) goto L63
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
            boolean r1 = r1 instanceof x.i
            if (r1 == 0) goto L52
            if (r2 != 0) goto L63
            if (r11 != r7) goto L65
            goto L63
        L52:
            return r2
        L53:
            if (r11 == r9) goto L5a
            if (r11 != r8) goto L58
            goto L5a
        L58:
            r2 = r0
            goto L5b
        L5a:
            r2 = r4
        L5b:
            boolean r1 = r1 instanceof x.i
            if (r1 == 0) goto L64
            if (r2 != 0) goto L63
            if (r11 != r6) goto L65
        L63:
            return r4
        L64:
            return r2
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x.d.i(x.d):boolean");
    }

    public final void j() {
        HashSet hashSet;
        d dVar = this.f;
        if (dVar != null && (hashSet = dVar.f14114a) != null) {
            hashSet.remove(this);
            if (this.f.f14114a.size() == 0) {
                this.f.f14114a = null;
            }
        }
        this.f14114a = null;
        this.f = null;
        this.f14119g = 0;
        this.f14120h = Integer.MIN_VALUE;
        this.f14116c = false;
        this.f14115b = 0;
    }

    public final void k() {
        v.f fVar = this.i;
        if (fVar == null) {
            this.i = new v.f(1);
        } else {
            fVar.c();
        }
    }

    public final void l(int i) {
        this.f14115b = i;
        this.f14116c = true;
    }

    public final String toString() {
        return this.f14117d.f14135h0 + ":" + c.c(this.f14118e);
    }
}
