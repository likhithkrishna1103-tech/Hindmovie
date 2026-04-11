package e6;

import android.graphics.Bitmap;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements j2.w, q6.a, r0.o {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4522u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f4523v;

    public /* synthetic */ i(int i, Object obj) {
        this.f4523v = obj;
        this.f4522u = i;
    }

    public void a(long j5) {
        int i = this.f4522u;
        long[] jArr = (long[]) this.f4523v;
        if (i == jArr.length) {
            this.f4523v = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = (long[]) this.f4523v;
        int i10 = this.f4522u;
        this.f4522u = i10 + 1;
        jArr2[i10] = j5;
    }

    public void b(long[] jArr) {
        int length = this.f4522u + jArr.length;
        long[] jArr2 = (long[]) this.f4523v;
        if (length > jArr2.length) {
            this.f4523v = Arrays.copyOf(jArr2, Math.max(jArr2.length * 2, length));
        }
        System.arraycopy(jArr, 0, (long[]) this.f4523v, this.f4522u, jArr.length);
        this.f4522u = length;
    }

    @Override // j2.w
    public MediaCodecInfo c(int i) {
        if (((MediaCodecInfo[]) this.f4523v) == null) {
            this.f4523v = new MediaCodecList(this.f4522u).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f4523v)[i];
    }

    public long d(int i) {
        if (i >= 0 && i < this.f4522u) {
            return ((long[]) this.f4523v)[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f4522u);
    }

    @Override // r0.o
    public boolean e(View view) {
        ((BottomSheetBehavior) this.f4523v).G(this.f4522u);
        return true;
    }

    @Override // q6.a
    public b0 f(b0 b0Var, c6.i iVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) b0Var.get()).compress((Bitmap.CompressFormat) this.f4523v, this.f4522u, byteArrayOutputStream);
        b0Var.d();
        return new l6.y(byteArrayOutputStream.toByteArray());
    }

    @Override // j2.w
    public boolean g(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // j2.w
    public int h() {
        if (((MediaCodecInfo[]) this.f4523v) == null) {
            this.f4523v = new MediaCodecList(this.f4522u).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f4523v).length;
    }

    public long i(w2.l lVar) {
        s1.u uVar = (s1.u) this.f4523v;
        int i = 0;
        lVar.r(uVar.f11709a, 0, 1, false);
        int i10 = uVar.f11709a[0] & 255;
        if (i10 == 0) {
            return Long.MIN_VALUE;
        }
        int i11 = 128;
        int i12 = 0;
        while ((i10 & i11) == 0) {
            i11 >>= 1;
            i12++;
        }
        int i13 = i10 & (~i11);
        lVar.r(uVar.f11709a, 1, i12, false);
        while (i < i12) {
            i++;
            i13 = (uVar.f11709a[i] & 255) + (i13 << 8);
        }
        this.f4522u = i12 + 1 + this.f4522u;
        return i13;
    }

    @Override // j2.w
    public boolean k(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // j2.w
    public boolean o() {
        return true;
    }

    public i(q7.b bVar, int i) {
        t7.v.h(bVar);
        this.f4523v = bVar;
        this.f4522u = i;
    }

    public i(int i) {
        this.f4523v = new long[i];
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(int i, boolean z2) {
        this(32);
        switch (i) {
            case 3:
                this.f4523v = Bitmap.CompressFormat.JPEG;
                this.f4522u = 100;
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                break;
            default:
                this.f4523v = new s1.u(8);
                break;
        }
    }
}
