package k4;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p0 implements c1, y1.h, j9.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7129v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ boolean f7130w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f7131x;

    public /* synthetic */ p0(Object obj, boolean z10, int i) {
        this.f7129v = i;
        this.f7131x = obj;
        this.f7130w = z10;
    }

    @Override // j9.f
    public void a(Object obj) {
        SharedPreferences.Editor editorEdit = n5.a.p((Context) this.f7131x).edit();
        editorEdit.putBoolean("proxy_retention", this.f7130w);
        editorEdit.apply();
    }

    @Override // y1.h
    public void accept(Object obj) {
        ((h1) obj).x0((v1.c) this.f7131x, this.f7130w);
    }

    @Override // k4.c1
    public Object i(b0 b0Var, s sVar, int i) {
        switch (this.f7129v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ua.z0 z0VarO = ua.i0.o((v1.g0) this.f7131x);
                boolean z10 = this.f7130w;
                return b0Var.q(sVar, z0VarO, z10 ? -1 : b0Var.f6924t.Y(), z10 ? -9223372036854775807L : b0Var.f6924t.V0());
            default:
                List list = (List) this.f7131x;
                boolean z11 = this.f7130w;
                return b0Var.q(sVar, list, z11 ? -1 : b0Var.f6924t.Y(), z11 ? -9223372036854775807L : b0Var.f6924t.V0());
        }
    }
}
