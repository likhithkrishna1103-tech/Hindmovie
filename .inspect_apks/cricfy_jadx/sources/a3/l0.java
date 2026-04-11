package a3;

import android.content.Context;
import android.os.Looper;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f218b;

    public l0(Context context, Looper looper, y1.v vVar, int i) {
        this.f217a = i;
        switch (i) {
            case 2:
                new f9.c0(context.getApplicationContext());
                vVar.a(looper, null);
                break;
            default:
                new f9.b0(context.getApplicationContext());
                vVar.a(looper, null);
                break;
        }
    }

    public void a(boolean z10) {
        switch (this.f217a) {
            case 1:
                if (this.f218b != z10) {
                    this.f218b = z10;
                    break;
                }
                break;
            default:
                if (this.f218b != z10) {
                    this.f218b = z10;
                    break;
                }
                break;
        }
    }

    public l0(boolean z10) {
        this.f217a = 0;
        this.f218b = z10;
    }

    public l0(z1.o oVar, z1.q qVar) throws z1.p {
        this.f217a = 3;
        int i = qVar.f15126a;
        ByteBuffer byteBuffer = qVar.f15127b;
        y1.d.b(i == 6 || i == 3);
        int iMin = Math.min(4, byteBuffer.remaining());
        byte[] bArr = new byte[iMin];
        byteBuffer.asReadOnlyBuffer().get(bArr);
        k0 k0Var = new k0(iMin, bArr);
        oVar.getClass();
        if (k0Var.h()) {
            this.f218b = false;
            return;
        }
        int i10 = k0Var.i(2);
        if (!k0Var.h()) {
            this.f218b = true;
            return;
        }
        if (i10 != 3 && i10 != 0) {
            k0Var.h();
        }
        k0Var.s();
        throw new z1.p();
    }
}
