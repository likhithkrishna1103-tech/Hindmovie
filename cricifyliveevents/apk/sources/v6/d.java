package v6;

import a7.g;
import android.graphics.Bitmap;
import android.util.Log;
import i2.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f13478a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f13480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteBuffer f13481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f13482e;
    public short[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f13483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f13484h;
    public byte[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f13485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f13487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f13488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f13489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f13491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f13492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f13493r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f13494s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f13479b = new int[256];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Bitmap.Config f13495t = Bitmap.Config.ARGB_8888;

    public d(k kVar, b bVar, ByteBuffer byteBuffer, int i) {
        this.f13480c = kVar;
        this.f13487l = new b();
        synchronized (this) {
            try {
                if (i <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
                }
                int iHighestOneBit = Integer.highestOneBit(i);
                int i10 = 0;
                this.f13490o = 0;
                this.f13487l = bVar;
                this.f13486k = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f13481d = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.f13481d.order(ByteOrder.LITTLE_ENDIAN);
                this.f13489n = false;
                ArrayList arrayList = bVar.f13469e;
                int size = arrayList.size();
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    Object obj = arrayList.get(i10);
                    i10++;
                    if (((a) obj).f13461g == 3) {
                        this.f13489n = true;
                        break;
                    }
                }
                this.f13491p = iHighestOneBit;
                int i11 = bVar.f;
                this.f13493r = i11 / iHighestOneBit;
                int i12 = bVar.f13470g;
                this.f13492q = i12 / iHighestOneBit;
                int i13 = i11 * i12;
                g gVar = (g) this.f13480c.f6086w;
                this.i = gVar == null ? new byte[i13] : (byte[]) gVar.d(i13, byte[].class);
                k kVar2 = this.f13480c;
                int i14 = this.f13493r * this.f13492q;
                g gVar2 = (g) kVar2.f6086w;
                this.f13485j = gVar2 == null ? new int[i14] : (int[]) gVar2.d(i14, int[].class);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bitmap a() {
        Boolean bool = this.f13494s;
        Bitmap bitmapB = ((a7.b) this.f13480c.f6085v).b(this.f13493r, this.f13492q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f13495t);
        bitmapB.setHasAlpha(true);
        return bitmapB;
    }

    public final synchronized Bitmap b() {
        try {
            if (this.f13487l.f13467c <= 0 || this.f13486k < 0) {
                if (Log.isLoggable("d", 3)) {
                    Log.d("d", "Unable to decode frame, frameCount=" + this.f13487l.f13467c + ", framePointer=" + this.f13486k);
                }
                this.f13490o = 1;
            }
            int i = this.f13490o;
            if (i != 1 && i != 2) {
                this.f13490o = 0;
                if (this.f13482e == null) {
                    g gVar = (g) this.f13480c.f6086w;
                    this.f13482e = gVar == null ? new byte[255] : (byte[]) gVar.d(255, byte[].class);
                }
                a aVar = (a) this.f13487l.f13469e.get(this.f13486k);
                int i10 = this.f13486k - 1;
                a aVar2 = i10 >= 0 ? (a) this.f13487l.f13469e.get(i10) : null;
                int[] iArr = aVar.f13464k;
                if (iArr == null) {
                    iArr = this.f13487l.f13465a;
                }
                this.f13478a = iArr;
                if (iArr == null) {
                    if (Log.isLoggable("d", 3)) {
                        Log.d("d", "No valid color table found for frame #" + this.f13486k);
                    }
                    this.f13490o = 1;
                    return null;
                }
                if (aVar.f) {
                    System.arraycopy(iArr, 0, this.f13479b, 0, iArr.length);
                    int[] iArr2 = this.f13479b;
                    this.f13478a = iArr2;
                    iArr2[aVar.f13462h] = 0;
                    if (aVar.f13461g == 2 && this.f13486k == 0) {
                        this.f13494s = Boolean.TRUE;
                    }
                }
                return d(aVar, aVar2);
            }
            if (Log.isLoggable("d", 3)) {
                Log.d("d", "Unable to decode frame, status=" + this.f13490o);
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
            this.f13495t = config;
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
    public final android.graphics.Bitmap d(v6.a r36, v6.a r37) {
        /*
            Method dump skipped, instruction units count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.d.d(v6.a, v6.a):android.graphics.Bitmap");
    }
}
