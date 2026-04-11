package a6;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.internal.measurement.k4;
import f6.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f593a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k4 f595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteBuffer f596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f597e;
    public short[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f599h;
    public byte[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f602l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f603m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f604n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f605o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f606p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f607q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f608r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f609s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f594b = new int[256];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Bitmap.Config f610t = Bitmap.Config.ARGB_8888;

    public d(k4 k4Var, b bVar, ByteBuffer byteBuffer, int i) {
        this.f595c = k4Var;
        this.f602l = new b();
        synchronized (this) {
            try {
                if (i <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
                }
                int iHighestOneBit = Integer.highestOneBit(i);
                int i10 = 0;
                this.f605o = 0;
                this.f602l = bVar;
                this.f601k = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f596d = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.f596d.order(ByteOrder.LITTLE_ENDIAN);
                this.f604n = false;
                ArrayList arrayList = bVar.f584e;
                int size = arrayList.size();
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    Object obj = arrayList.get(i10);
                    i10++;
                    if (((a) obj).f576g == 3) {
                        this.f604n = true;
                        break;
                    }
                }
                this.f606p = iHighestOneBit;
                int i11 = bVar.f;
                this.f608r = i11 / iHighestOneBit;
                int i12 = bVar.f585g;
                this.f607q = i12 / iHighestOneBit;
                int i13 = i11 * i12;
                f fVar = (f) this.f595c.f3071v;
                this.i = fVar == null ? new byte[i13] : (byte[]) fVar.d(i13, byte[].class);
                k4 k4Var2 = this.f595c;
                int i14 = this.f608r * this.f607q;
                f fVar2 = (f) k4Var2.f3071v;
                this.f600j = fVar2 == null ? new int[i14] : (int[]) fVar2.d(i14, int[].class);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bitmap a() {
        Boolean bool = this.f609s;
        Bitmap bitmapD = ((f6.a) this.f595c.f3070u).d(this.f608r, this.f607q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f610t);
        bitmapD.setHasAlpha(true);
        return bitmapD;
    }

    public final synchronized Bitmap b() {
        try {
            if (this.f602l.f582c <= 0 || this.f601k < 0) {
                if (Log.isLoggable("d", 3)) {
                    Log.d("d", "Unable to decode frame, frameCount=" + this.f602l.f582c + ", framePointer=" + this.f601k);
                }
                this.f605o = 1;
            }
            int i = this.f605o;
            if (i != 1 && i != 2) {
                this.f605o = 0;
                if (this.f597e == null) {
                    f fVar = (f) this.f595c.f3071v;
                    this.f597e = fVar == null ? new byte[255] : (byte[]) fVar.d(255, byte[].class);
                }
                a aVar = (a) this.f602l.f584e.get(this.f601k);
                int i10 = this.f601k - 1;
                a aVar2 = i10 >= 0 ? (a) this.f602l.f584e.get(i10) : null;
                int[] iArr = aVar.f579k;
                if (iArr == null) {
                    iArr = this.f602l.f580a;
                }
                this.f593a = iArr;
                if (iArr == null) {
                    if (Log.isLoggable("d", 3)) {
                        Log.d("d", "No valid color table found for frame #" + this.f601k);
                    }
                    this.f605o = 1;
                    return null;
                }
                if (aVar.f) {
                    System.arraycopy(iArr, 0, this.f594b, 0, iArr.length);
                    int[] iArr2 = this.f594b;
                    this.f593a = iArr2;
                    iArr2[aVar.f577h] = 0;
                    if (aVar.f576g == 2 && this.f601k == 0) {
                        this.f609s = Boolean.TRUE;
                    }
                }
                return d(aVar, aVar2);
            }
            if (Log.isLoggable("d", 3)) {
                Log.d("d", "Unable to decode frame, status=" + this.f605o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f610t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01dc A[PHI: r5
      0x01dc: PHI (r5v44 int) = (r5v38 int), (r5v46 int), (r5v46 int) binds: [B:93:0x01c8, B:95:0x01d3, B:96:0x01d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v31, types: [short] */
    /* JADX WARN: Type inference failed for: r6v33 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap d(a6.a r36, a6.a r37) {
        /*
            Method dump skipped, instruction units count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.d.d(a6.a, a6.a):android.graphics.Bitmap");
    }
}
