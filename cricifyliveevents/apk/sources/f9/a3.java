package f9;

import android.app.Service;
import android.content.Intent;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4003v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f4004w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4005x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f4006y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Cloneable f4007z;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ a3(z0 z0Var, int i, Exception exc, byte[] bArr, Map map) {
        this.f4005x = z0Var;
        this.f4004w = i;
        this.f4006y = exc;
        this.f4007z = bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4003v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z0 z0Var = (z0) this.f4005x;
                ((z2) z0Var.A).f(this.f4004w, (Exception) this.f4006y, (byte[]) this.f4007z);
                break;
            default:
                pc.c cVar = (pc.c) this.f4005x;
                w0 w0Var = (w0) this.f4006y;
                Intent intent = (Intent) this.f4007z;
                Service service = (Service) cVar.f10180v;
                w3 w3Var = (w3) service;
                int i = this.f4004w;
                if (w3Var.a(i)) {
                    w0Var.J.b(Integer.valueOf(i), "Local AppMeasurementService processed last upload request. StartId");
                    w0 w0Var2 = r1.m(service, null, null).A;
                    r1.g(w0Var2);
                    w0Var2.J.a("Completed wakeful intent.");
                    w3Var.b(intent);
                }
                break;
        }
    }

    public /* synthetic */ a3(pc.c cVar, int i, w0 w0Var, Intent intent) {
        this.f4005x = cVar;
        this.f4004w = i;
        this.f4006y = w0Var;
        this.f4007z = intent;
    }
}
