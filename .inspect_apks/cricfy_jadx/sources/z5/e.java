package z5;

import androidx.media3.decoder.DecoderInputBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements k {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f15210v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ i f15211w;

    public /* synthetic */ e(i iVar, int i) {
        this.f15210v = i;
        this.f15211w = iVar;
    }

    @Override // z5.k
    public final void f(String str, boolean z10) {
        int i;
        int iIndexOf;
        switch (this.f15210v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i iVar = this.f15211w;
                try {
                    iVar.j(new JSONObject(ab.b.g(str)).getString("playback_url"), null);
                } catch (JSONException unused) {
                    iVar.j("error", null);
                    return;
                }
                break;
            default:
                i iVar2 = this.f15211w;
                String strReplace = "https://error.m3u8";
                if (!z10) {
                    iVar2.j("https://error.m3u8", null);
                } else {
                    int iIndexOf2 = str.indexOf("hlsManifestUrl\":\"");
                    if (iIndexOf2 != -1 && (iIndexOf = str.indexOf(".m3u8", (i = iIndexOf2 + 17))) != -1) {
                        strReplace = str.substring(i, iIndexOf + 5).replace("\\u0026", "&").replace("\\/", "/");
                    }
                    iVar2.j(strReplace, null);
                }
                break;
        }
    }
}
