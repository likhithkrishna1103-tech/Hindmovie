package a2;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements s1.m, s1.h, r0.o {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f475u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f476v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f477w;

    public /* synthetic */ x(int i, int i10, Object obj) {
        this.f475u = i10;
        this.f477w = obj;
        this.f476v = i;
    }

    @Override // s1.m
    public void a(Object obj) {
        switch (this.f475u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p1.u0) obj).k(((u1) this.f477w).f448a, this.f476v);
                break;
            default:
                p1.u0 u0Var = (p1.u0) obj;
                u0Var.o(this.f476v, (p1.g0) this.f477w);
                break;
        }
    }

    @Override // s1.h
    public void accept(Object obj) {
        g4.m mVar;
        g4.m mVar2;
        g4.s sVar = (g4.s) this.f477w;
        int i = this.f476v;
        try {
            mVar2 = (g4.m) ((ea.y) obj).get();
            s1.d.e(mVar2, "LibraryResult must not be null");
        } catch (InterruptedException e10) {
            e = e10;
            s1.b.q("MediaSessionStub", "Library operation failed", e);
            String str = g4.m.f5108d;
            g4.o1 o1Var = new g4.o1(-1, "no error message provided", Bundle.EMPTY);
            mVar = new g4.m(o1Var.f5151a, SystemClock.elapsedRealtime(), o1Var);
            mVar2 = mVar;
        } catch (CancellationException e11) {
            s1.b.q("MediaSessionStub", "Library operation cancelled", e11);
            String str2 = g4.m.f5108d;
            g4.o1 o1Var2 = new g4.o1(1, "no error message provided", Bundle.EMPTY);
            mVar = new g4.m(o1Var2.f5151a, SystemClock.elapsedRealtime(), o1Var2);
            mVar2 = mVar;
        } catch (ExecutionException e12) {
            e = e12;
            s1.b.q("MediaSessionStub", "Library operation failed", e);
            String str3 = g4.m.f5108d;
            g4.o1 o1Var3 = new g4.o1(-1, "no error message provided", Bundle.EMPTY);
            mVar = new g4.m(o1Var3.f5151a, SystemClock.elapsedRealtime(), o1Var3);
            mVar2 = mVar;
        }
        try {
            g4.r rVar = sVar.f5202d;
            s1.d.h(rVar);
            rVar.e(i, mVar2);
        } catch (RemoteException e13) {
            s1.b.q("MediaSessionStub", "Failed to send result to browser " + sVar, e13);
        }
    }

    @Override // r0.o
    public boolean e(View view) {
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f477w;
        int i = SideSheetBehavior.R;
        sideSheetBehavior.w(this.f476v);
        return true;
    }
}
