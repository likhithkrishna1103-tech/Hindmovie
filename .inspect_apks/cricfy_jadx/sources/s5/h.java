package s5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.card.MaterialCardView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends x0 {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final LottieAnimationView E;
    public final TextView F;
    public int G;
    public final /* synthetic */ i H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MaterialCardView f11490u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageView f11491v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ImageView f11492w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ImageView f11493x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TextView f11494y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f11495z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, View view) {
        super(view);
        this.H = iVar;
        this.f11490u = (MaterialCardView) view.findViewById(q5.k.event_card);
        this.f11494y = (TextView) view.findViewById(q5.k.teamAName);
        this.f11495z = (TextView) view.findViewById(q5.k.teamBName);
        this.f11492w = (ImageView) view.findViewById(q5.k.teamAFlag);
        this.f11493x = (ImageView) view.findViewById(q5.k.teamBFlag);
        this.f11491v = (ImageView) view.findViewById(q5.k.event_logo);
        this.C = (TextView) view.findViewById(q5.k.title_txt);
        this.A = (TextView) view.findViewById(q5.k.date_text);
        this.B = (TextView) view.findViewById(q5.k.time_text);
        this.F = (TextView) view.findViewById(q5.k.status_txt);
        this.D = (TextView) view.findViewById(q5.k.hotLabel);
        this.E = (LottieAnimationView) view.findViewById(q5.k.live_anim_view);
    }

    public final void q(y5.e eVar) {
        String str;
        String str2 = eVar.f14930j + "|" + eVar.i;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss");
        SimpleDateFormat simpleDateFormatJ = j4.j("dd/MM/yyyy|HH:mm:ss");
        try {
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            str = simpleDateFormat.format(simpleDateFormatJ.parse(str2));
        } catch (ParseException unused) {
            str = null;
        }
        String[] strArrSplit = str.split("\\|");
        String[] strArrSplit2 = strArrSplit[1].split("\\s+")[0].split(":");
        int i = Integer.parseInt(strArrSplit2[0]);
        int i10 = Integer.parseInt(strArrSplit2[1]);
        String str3 = i < 12 ? " AM" : " PM";
        int i11 = i % 12;
        int i12 = i11 != 0 ? i11 : 12;
        StringBuilder sb = new StringBuilder();
        sb.append(i12 < 10 ? l0.e.g(i12, "0") : Integer.valueOf(i12));
        sb.append(":");
        sb.append(i10 < 10 ? l0.e.g(i10, "0") : Integer.valueOf(i10));
        sb.append(str3);
        String string = sb.toString();
        TextView textView = this.B;
        textView.setText(string);
        String str4 = strArrSplit[0];
        TextView textView2 = this.A;
        textView2.setText(str4);
        textView2.setVisibility(0);
        textView.setVisibility(0);
        this.E.setVisibility(8);
    }
}
