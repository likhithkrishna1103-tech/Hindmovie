package d7;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f3460b;

    public /* synthetic */ c0(t tVar, int i) {
        this.f3459a = i;
        this.f3460b = tVar;
    }

    @Override // d7.t
    public final s a(Object obj, int i, int i10, x6.h hVar) {
        Uri uriFromFile;
        switch (this.f3459a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    uriFromFile = null;
                } else if (str.charAt(0) == '/') {
                    uriFromFile = Uri.fromFile(new File(str));
                } else {
                    Uri uri = Uri.parse(str);
                    uriFromFile = uri.getScheme() == null ? Uri.fromFile(new File(str)) : uri;
                }
                if (uriFromFile == null) {
                    return null;
                }
                t tVar = this.f3460b;
                if (tVar.b(uriFromFile)) {
                    return tVar.a(uriFromFile, i, i10, hVar);
                }
                return null;
            default:
                return this.f3460b.a(new j((URL) obj), i, i10, hVar);
        }
    }

    @Override // d7.t
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        switch (this.f3459a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                break;
        }
        return true;
    }
}
