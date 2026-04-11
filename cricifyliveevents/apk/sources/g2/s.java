package g2;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements y1.m, y1.h, u0.o {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4894v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f4895w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4896x;

    public /* synthetic */ s(int i, int i10, Object obj) {
        this.f4894v = i10;
        this.f4896x = obj;
        this.f4895w = i;
    }

    @Override // y1.m
    public void a(Object obj) {
        switch (this.f4894v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((v1.u0) obj).e(((i1) this.f4896x).f4750a, this.f4895w);
                break;
            default:
                v1.u0 u0Var = (v1.u0) obj;
                u0Var.k(this.f4895w, (v1.g0) this.f4896x);
                break;
        }
    }

    @Override // y1.h
    public void accept(Object obj) {
        k4.m mVar;
        k4.m mVar2;
        k4.s sVar = (k4.s) this.f4896x;
        int i = this.f4895w;
        try {
            mVar2 = (k4.m) ((ya.w) obj).get();
            y1.d.e(mVar2, "LibraryResult must not be null");
        } catch (InterruptedException e9) {
            e = e9;
            y1.b.q("MediaSessionStub", "Library operation failed", e);
            String str = k4.m.f7077d;
            k4.m1 m1Var = new k4.m1(-1, "no error message provided", Bundle.EMPTY);
            mVar = new k4.m(m1Var.f7088a, SystemClock.elapsedRealtime(), m1Var);
            mVar2 = mVar;
        } catch (CancellationException e10) {
            y1.b.q("MediaSessionStub", "Library operation cancelled", e10);
            String str2 = k4.m.f7077d;
            k4.m1 m1Var2 = new k4.m1(1, "no error message provided", Bundle.EMPTY);
            mVar = new k4.m(m1Var2.f7088a, SystemClock.elapsedRealtime(), m1Var2);
            mVar2 = mVar;
        } catch (ExecutionException e11) {
            e = e11;
            y1.b.q("MediaSessionStub", "Library operation failed", e);
            String str3 = k4.m.f7077d;
            k4.m1 m1Var3 = new k4.m1(-1, "no error message provided", Bundle.EMPTY);
            mVar = new k4.m(m1Var3.f7088a, SystemClock.elapsedRealtime(), m1Var3);
            mVar2 = mVar;
        }
        try {
            k4.r rVar = sVar.f7160d;
            y1.d.h(rVar);
            rVar.l(i, mVar2);
        } catch (RemoteException e12) {
            y1.b.q("MediaSessionStub", "Failed to send result to browser " + sVar, e12);
        }
    }

    @Override // u0.o
    public boolean c(View view) {
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4896x;
        int i = SideSheetBehavior.S;
        sideSheetBehavior.w(this.f4895w);
        return true;
    }
}
