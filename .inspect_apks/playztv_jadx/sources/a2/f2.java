package a2;

import android.content.Context;
import android.os.Looper;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f230b;

    public f2(Context context, Looper looper, s1.w wVar, int i) {
        this.f229a = i;
        switch (i) {
            case 1:
                new t7.j(context.getApplicationContext());
                wVar.a(looper, null);
                break;
            default:
                new q9.e(context.getApplicationContext());
                wVar.a(looper, null);
                break;
        }
    }

    public void a(boolean z2) {
        switch (this.f229a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f230b != z2) {
                    this.f230b = z2;
                    break;
                }
                break;
            default:
                if (this.f230b != z2) {
                    this.f230b = z2;
                    break;
                }
                break;
        }
    }

    public f2(boolean z2) {
        this.f229a = 3;
        this.f230b = z2;
    }

    public f2(t1.p pVar, t1.r rVar) throws t1.q {
        this.f229a = 2;
        int i = rVar.f12061a;
        ByteBuffer byteBuffer = rVar.f12062b;
        s1.d.b(i == 6 || i == 3);
        int iMin = Math.min(4, byteBuffer.remaining());
        byte[] bArr = new byte[iMin];
        byteBuffer.asReadOnlyBuffer().get(bArr);
        s1.t tVar = new s1.t(iMin, bArr);
        pVar.getClass();
        if (tVar.h()) {
            this.f230b = false;
            return;
        }
        int i10 = tVar.i(2);
        if (!tVar.h()) {
            this.f230b = true;
            return;
        }
        if (i10 != 3 && i10 != 0) {
            tVar.h();
        }
        tVar.s();
        throw new t1.q();
    }
}
