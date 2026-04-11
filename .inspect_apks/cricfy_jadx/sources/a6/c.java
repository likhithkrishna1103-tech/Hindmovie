package a6;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.TvActivity;
import com.bumptech.glide.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d8.f;
import g1.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import s5.p;
import x5.n;
import x5.r;
import y5.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f304v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f305w;

    public /* synthetic */ c(int i, Object obj) {
        this.f304v = i;
        this.f305w = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i10 = this.f304v;
        Object obj = this.f305w;
        switch (i10) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((Activity) ((Context) obj)).finish();
                break;
            case 1:
                ((Activity) obj).finish();
                break;
            case 2:
                int i11 = MainActivity.B0;
                ((MainActivity) obj).finish();
                break;
            case 3:
                int i12 = TvActivity.f1550s0;
                ((TvActivity) obj).finish();
                break;
            case h.LONG_FIELD_NUMBER /* 4 */:
                f fVar = (f) obj;
                p pVar = (p) fVar.f3538w;
                i iVar = (i) fVar.f3539x;
                int i13 = fVar.f3537v;
                Context context = pVar.f11521e;
                String str = iVar.f14951a;
                String str2 = iVar.f14952b;
                String str3 = iVar.f14953c;
                String str4 = iVar.f14954d;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("*");
                sb.append(str2);
                sb.append("*");
                sb.append(str3);
                String strQ = q4.a.q(sb, "*", str4);
                Set<String> stringSet = d.t(context).getStringSet("list", new HashSet());
                HashSet hashSet = new HashSet();
                for (String str5 : stringSet) {
                    if (!str5.equals(strQ)) {
                        hashSet.add(str5);
                    }
                }
                context.getSharedPreferences("DataPreferences", 0).edit().putStringSet("list", hashSet).apply();
                ((ArrayList) pVar.f11522g).remove(i13);
                ((r) ((kf.i) pVar.f).f7483w).f14377u0 = new ArrayList((ArrayList) pVar.f11522g);
                pVar.f13407a.e(i13);
                break;
            default:
                x5.p pVar2 = (x5.p) obj;
                new Thread(new n(pVar2, 2)).start();
                pVar2.f14373x0.clear();
                pVar2.V();
                ((FloatingActionButton) pVar2.f14370u0.f3673x).setVisibility(8);
                break;
        }
    }
}
