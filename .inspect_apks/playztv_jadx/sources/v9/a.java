package v9;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f13340b;

    public /* synthetic */ a(n nVar, int i) {
        this.f13339a = i;
        this.f13340b = nVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        switch (this.f13339a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                d dVar = (d) this.f13340b;
                dVar.s(dVar.t());
                break;
            default:
                j jVar = (j) this.f13340b;
                jVar.f13361l = z2;
                jVar.p();
                if (!z2) {
                    jVar.s(false);
                    jVar.f13362m = false;
                }
                break;
        }
    }
}
