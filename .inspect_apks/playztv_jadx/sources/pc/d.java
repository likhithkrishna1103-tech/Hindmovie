package pc;

import androidx.media3.decoder.DecoderInputBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10319u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ i f10320v;

    public /* synthetic */ d(i iVar, int i) {
        this.f10319u = i;
        this.f10320v = iVar;
    }

    @Override // pc.l
    public final void f(String str, boolean z2) {
        int i;
        int iIndexOf;
        switch (this.f10319u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i iVar = this.f10320v;
                try {
                    iVar.l(new JSONObject(com.bumptech.glide.d.h(str)).getString("playback_url"), null);
                } catch (JSONException unused) {
                    iVar.l("error", null);
                    return;
                }
                break;
            default:
                i iVar2 = this.f10320v;
                String strReplace = "https://error.m3u8";
                if (!z2) {
                    iVar2.l("https://error.m3u8", null);
                } else {
                    int iIndexOf2 = str.indexOf("hlsManifestUrl\":\"");
                    if (iIndexOf2 != -1 && (iIndexOf = str.indexOf(".m3u8", (i = iIndexOf2 + 17))) != -1) {
                        strReplace = str.substring(i, iIndexOf + 5).replace("\\u0026", "&").replace("\\/", "/");
                    }
                    iVar2.l(strReplace, null);
                }
                break;
        }
    }
}
