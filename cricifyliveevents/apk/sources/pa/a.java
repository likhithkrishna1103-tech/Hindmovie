package pa;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10048b;

    public /* synthetic */ a(int i, Object obj) {
        this.f10047a = i;
        this.f10048b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        switch (this.f10047a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = (e) this.f10048b;
                eVar.s(eVar.t());
                break;
            case 1:
                l lVar = (l) this.f10048b;
                lVar.f10076l = z10;
                lVar.p();
                if (!z10) {
                    lVar.s(false);
                    lVar.f10077m = false;
                }
                break;
            default:
                ((s5.d) this.f10048b).f11480w.setVisibility(z10 ? 0 : 8);
                break;
        }
    }
}
