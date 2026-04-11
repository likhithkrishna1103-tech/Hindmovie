package s5;

import android.text.TextUtils;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.app.ProApplication;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f11473v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f11474w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f11475x;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f11473v = i;
        this.f11474w = obj;
        this.f11475x = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        switch (this.f11473v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = (e) this.f11474w;
                y5.c cVar = (y5.c) this.f11475x;
                ProApplication proApplication = eVar.f11482e;
                proApplication.B = proApplication.C;
                v5.h.V(eVar.f, cVar.f, cVar.f14915c, cVar.f14913a, cVar.f14916d.equals("custom"), eVar.f11481d);
                break;
            default:
                h hVar = (h) this.f11474w;
                y5.e eVar2 = (y5.e) this.f11475x;
                i iVar = hVar.H;
                ProApplication proApplication2 = iVar.f11496d;
                proApplication2.f1572z = proApplication2.A;
                StringBuilder sb = new StringBuilder();
                sb.append(eVar2.f14926d);
                if (TextUtils.isEmpty(eVar2.f14927e)) {
                    str = "";
                } else {
                    str = " vs " + eVar2.f14927e;
                }
                sb.append(str);
                v5.h.V(iVar.f11497e, eVar2.f14934n, eVar2.f14929h, sb.toString(), true, iVar.f11500j);
                break;
        }
    }
}
