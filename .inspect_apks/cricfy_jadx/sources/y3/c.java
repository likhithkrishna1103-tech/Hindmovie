package y3;

import j9.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x3.m;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends i {
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f14778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f14779k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f14783o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f14784p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14785q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14786r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f14787s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f14788t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte f14789u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte f14790v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14792x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f14793y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f14776z = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] A = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] B = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] C = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] D = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] E = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] F = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] G = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t f14777h = new t();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f14781m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f14782n = new b(0, 4);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14791w = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f14780l = 16000000;

    public c(int i, String str) {
        this.i = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.f14779k = 0;
            this.f14778j = 0;
        } else if (i == 2) {
            this.f14779k = 1;
            this.f14778j = 0;
        } else if (i == 3) {
            this.f14779k = 0;
            this.f14778j = 1;
        } else if (i != 4) {
            y1.b.p("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f14779k = 0;
            this.f14778j = 0;
        } else {
            this.f14779k = 1;
            this.f14778j = 1;
        }
        h(0);
        g();
        this.f14792x = true;
        this.f14793y = -9223372036854775807L;
    }

    @Override // y3.i
    public final q b() {
        List list = this.f14783o;
        this.f14784p = list;
        list.getClass();
        return new q(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6 A[FALL_THROUGH] */
    @Override // y3.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(y3.g r15) {
        /*
            Method dump skipped, instruction units count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.c.c(y3.g):void");
    }

    @Override // y3.i, e2.d
    /* JADX INFO: renamed from: d */
    public final m dequeueOutputBuffer() {
        m mVar;
        m mVarDequeueOutputBuffer = super.dequeueOutputBuffer();
        if (mVarDequeueOutputBuffer != null) {
            return mVarDequeueOutputBuffer;
        }
        long j4 = this.f14780l;
        if (j4 == -9223372036854775807L) {
            return null;
        }
        long j7 = this.f14793y;
        if (j7 == -9223372036854775807L || this.f14836e - j7 < j4 || (mVar = (m) this.f14833b.pollFirst()) == null) {
            return null;
        }
        this.f14783o = Collections.EMPTY_LIST;
        this.f14793y = -9223372036854775807L;
        q qVarB = b();
        long j10 = this.f14836e;
        mVar.timeUs = j10;
        mVar.f14311v = qVarB;
        mVar.f14312w = j10;
        return mVar;
    }

    @Override // y3.i
    public final boolean e() {
        return this.f14783o != this.f14784p;
    }

    public final ArrayList f() {
        ArrayList arrayList = this.f14781m;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        int iMin = 2;
        for (int i = 0; i < size; i++) {
            x1.b bVarC = ((b) arrayList.get(i)).c(Integer.MIN_VALUE);
            arrayList2.add(bVarC);
            if (bVarC != null) {
                iMin = Math.min(iMin, bVarC.i);
            }
        }
        ArrayList arrayList3 = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            x1.b bVarC2 = (x1.b) arrayList2.get(i10);
            if (bVarC2 != null) {
                if (bVarC2.i != iMin) {
                    bVarC2 = ((b) arrayList.get(i10)).c(iMin);
                    bVarC2.getClass();
                }
                arrayList3.add(bVarC2);
            }
        }
        return arrayList3;
    }

    @Override // y3.i, e2.d
    public final void flush() {
        super.flush();
        this.f14783o = null;
        this.f14784p = null;
        h(0);
        this.f14786r = 4;
        this.f14782n.f14775h = 4;
        g();
        this.f14787s = false;
        this.f14788t = false;
        this.f14789u = (byte) 0;
        this.f14790v = (byte) 0;
        this.f14791w = 0;
        this.f14792x = true;
        this.f14793y = -9223372036854775807L;
    }

    public final void g() {
        b bVar = this.f14782n;
        bVar.f14774g = this.f14785q;
        bVar.f14769a.clear();
        bVar.f14770b.clear();
        bVar.f14771c.setLength(0);
        bVar.f14772d = 15;
        bVar.f14773e = 0;
        bVar.f = 0;
        ArrayList arrayList = this.f14781m;
        arrayList.clear();
        arrayList.add(this.f14782n);
    }

    public final void h(int i) {
        int i10 = this.f14785q;
        if (i10 == i) {
            return;
        }
        this.f14785q = i;
        if (i != 3) {
            g();
            if (i10 == 3 || i == 1 || i == 0) {
                this.f14783o = Collections.EMPTY_LIST;
                return;
            }
            return;
        }
        int i11 = 0;
        while (true) {
            ArrayList arrayList = this.f14781m;
            if (i11 >= arrayList.size()) {
                return;
            }
            ((b) arrayList.get(i11)).f14774g = i;
            i11++;
        }
    }

    @Override // y3.i, e2.d
    public final void release() {
    }
}
