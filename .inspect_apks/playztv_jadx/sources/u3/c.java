package u3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o8.j;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends i {
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f12702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f12703k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f12707o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f12708p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12709q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12710r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12711s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12712t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte f12713u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte f12714v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12716x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f12717y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f12700z = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] A = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] B = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] C = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] D = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] E = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] F = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] G = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u f12701h = new u();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f12705m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f12706n = new b(0, 4);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12715w = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f12704l = 16000000;

    public c(String str, int i) {
        this.i = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.f12703k = 0;
            this.f12702j = 0;
        } else if (i == 2) {
            this.f12703k = 1;
            this.f12702j = 0;
        } else if (i == 3) {
            this.f12703k = 0;
            this.f12702j = 1;
        } else if (i != 4) {
            s1.b.p("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f12703k = 0;
            this.f12702j = 0;
        } else {
            this.f12703k = 1;
            this.f12702j = 1;
        }
        h(0);
        g();
        this.f12716x = true;
        this.f12717y = -9223372036854775807L;
    }

    @Override // u3.i
    public final j b() {
        List list = this.f12707o;
        this.f12708p = list;
        list.getClass();
        return new j(1, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6 A[FALL_THROUGH] */
    @Override // u3.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(u3.g r15) {
        /*
            Method dump skipped, instruction units count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.c.c(u3.g):void");
    }

    @Override // u3.i, y1.d
    /* JADX INFO: renamed from: d */
    public final t3.j dequeueOutputBuffer() {
        t3.j jVar;
        t3.j jVarDequeueOutputBuffer = super.dequeueOutputBuffer();
        if (jVarDequeueOutputBuffer != null) {
            return jVarDequeueOutputBuffer;
        }
        long j5 = this.f12704l;
        if (j5 == -9223372036854775807L) {
            return null;
        }
        long j8 = this.f12717y;
        if (j8 == -9223372036854775807L || this.f12760e - j8 < j5 || (jVar = (t3.j) this.f12757b.pollFirst()) == null) {
            return null;
        }
        this.f12707o = Collections.EMPTY_LIST;
        this.f12717y = -9223372036854775807L;
        j jVarB = b();
        long j10 = this.f12760e;
        jVar.timeUs = j10;
        jVar.f12090u = jVarB;
        jVar.f12091v = j10;
        return jVar;
    }

    @Override // u3.i
    public final boolean e() {
        return this.f12707o != this.f12708p;
    }

    public final ArrayList f() {
        ArrayList arrayList = this.f12705m;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        int iMin = 2;
        for (int i = 0; i < size; i++) {
            r1.b bVarC = ((b) arrayList.get(i)).c(Integer.MIN_VALUE);
            arrayList2.add(bVarC);
            if (bVarC != null) {
                iMin = Math.min(iMin, bVarC.i);
            }
        }
        ArrayList arrayList3 = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            r1.b bVarC2 = (r1.b) arrayList2.get(i10);
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

    @Override // u3.i, y1.d
    public final void flush() {
        super.flush();
        this.f12707o = null;
        this.f12708p = null;
        h(0);
        this.f12710r = 4;
        this.f12706n.f12699h = 4;
        g();
        this.f12711s = false;
        this.f12712t = false;
        this.f12713u = (byte) 0;
        this.f12714v = (byte) 0;
        this.f12715w = 0;
        this.f12716x = true;
        this.f12717y = -9223372036854775807L;
    }

    public final void g() {
        b bVar = this.f12706n;
        bVar.f12698g = this.f12709q;
        bVar.f12693a.clear();
        bVar.f12694b.clear();
        bVar.f12695c.setLength(0);
        bVar.f12696d = 15;
        bVar.f12697e = 0;
        bVar.f = 0;
        ArrayList arrayList = this.f12705m;
        arrayList.clear();
        arrayList.add(this.f12706n);
    }

    public final void h(int i) {
        int i10 = this.f12709q;
        if (i10 == i) {
            return;
        }
        this.f12709q = i;
        if (i != 3) {
            g();
            if (i10 == 3 || i == 1 || i == 0) {
                this.f12707o = Collections.EMPTY_LIST;
                return;
            }
            return;
        }
        int i11 = 0;
        while (true) {
            ArrayList arrayList = this.f12705m;
            if (i11 >= arrayList.size()) {
                return;
            }
            ((b) arrayList.get(i11)).f12698g = i;
            i11++;
        }
    }

    @Override // u3.i, y1.d
    public final void release() {
    }
}
