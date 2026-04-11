package f1;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.media3.decoder.DecoderInputBuffer;
import ge.i;
import ge.j;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends j implements fe.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f3916w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Context f3917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f3918y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Context context, Object obj, int i) {
        super(0);
        this.f3916w = i;
        this.f3917x = context;
        this.f3918y = obj;
    }

    @Override // fe.a
    public final Object b() {
        switch (this.f3916w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SharedPreferences sharedPreferences = this.f3917x.getSharedPreferences((String) this.f3918y, 0);
                i.d(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
                return sharedPreferences;
            default:
                Context context = this.f3917x;
                i.d(context, "applicationContext");
                String str = ((g1.a) this.f3918y).f4611b;
                i.e(str, "name");
                return ab.b.e(context, str.concat(".preferences_pb"));
        }
    }
}
