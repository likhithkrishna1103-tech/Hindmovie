package i8;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6352c;

    public /* synthetic */ a(String str, boolean z10, int i) {
        this.f6350a = i;
        this.f6351b = str;
        this.f6352c = z10;
    }

    public String toString() {
        switch (this.f6350a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = this.f6351b;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
                sb.append("{");
                sb.append(str);
                sb.append("}");
                sb.append(this.f6352c);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(boolean z10, String str, int i) {
        this.f6350a = i;
        this.f6352c = z10;
        this.f6351b = str;
    }
}
