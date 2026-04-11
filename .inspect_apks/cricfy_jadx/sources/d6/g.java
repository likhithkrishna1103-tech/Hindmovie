package d6;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import s5.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements z5.k, m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3413v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ k f3414w;

    public /* synthetic */ g(k kVar, int i) {
        this.f3413v = i;
        this.f3414w = kVar;
    }

    @Override // s5.m
    public void b(String str, String str2, String str3, String str4, int i, boolean z10) {
        k kVar = this.f3414w;
        kVar.f3429j = str;
        kVar.f3430k = str2;
        kVar.f3431l = str3;
        kVar.f3437r = i;
        kVar.f3432m = str4;
        kVar.f3435p = z10;
        kVar.d(str, str2, str3, str4, null);
    }

    @Override // z5.k
    public void f(String str, boolean z10) {
        switch (this.f3413v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = this.f3414w;
                if (!z10) {
                    kVar.d("https://pro.com", "pro", null, null, null);
                } else {
                    kVar.i(str, false);
                }
                break;
            default:
                k kVar2 = this.f3414w;
                kVar2.getClass();
                Log.e("Pro Api Data", str);
                if (!z10) {
                    kVar2.d("https://pro.com", "pro", null, null, null);
                } else {
                    kVar2.i(str, false);
                }
                break;
        }
    }
}
