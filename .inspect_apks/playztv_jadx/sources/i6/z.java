package i6;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f6443b;

    public /* synthetic */ z(r rVar, int i) {
        this.f6442a = i;
        this.f6443b = rVar;
    }

    @Override // i6.r
    public final q a(Object obj, int i, int i10, c6.i iVar) {
        Uri uriFromFile;
        switch (this.f6442a) {
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
                r rVar = this.f6443b;
                if (rVar.b(uriFromFile)) {
                    return rVar.a(uriFromFile, i, i10, iVar);
                }
                return null;
            default:
                return this.f6443b.a(new h((URL) obj), i, i10, iVar);
        }
    }

    @Override // i6.r
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        switch (this.f6442a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                break;
        }
        return true;
    }
}
