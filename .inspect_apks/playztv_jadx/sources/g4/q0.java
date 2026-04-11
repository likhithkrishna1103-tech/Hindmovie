package g4;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q0 implements e1, s1.h, o8.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5183u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ boolean f5184v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f5185w;

    public /* synthetic */ q0(Object obj, boolean z2, int i) {
        this.f5183u = i;
        this.f5185w = obj;
        this.f5184v = z2;
    }

    @Override // s1.h
    public void accept(Object obj) {
        ((j1) obj).X0((p1.d) this.f5185w, this.f5184v);
    }

    @Override // o8.e
    public void c(Object obj) {
        SharedPreferences.Editor editorEdit = b8.h.p((Context) this.f5185w).edit();
        editorEdit.putBoolean("proxy_retention", this.f5184v);
        editorEdit.apply();
    }

    @Override // g4.e1
    public Object g(b0 b0Var, s sVar, int i) {
        switch (this.f5183u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                aa.c1 c1VarV = aa.j0.v((p1.g0) this.f5185w);
                boolean z2 = this.f5184v;
                return b0Var.q(sVar, c1VarV, z2 ? -1 : b0Var.f4973t.d0(), z2 ? -9223372036854775807L : b0Var.f4973t.T0());
            default:
                List list = (List) this.f5185w;
                boolean z10 = this.f5184v;
                return b0Var.q(sVar, list, z10 ? -1 : b0Var.f4973t.d0(), z10 ? -9223372036854775807L : b0Var.f4973t.T0());
        }
    }
}
