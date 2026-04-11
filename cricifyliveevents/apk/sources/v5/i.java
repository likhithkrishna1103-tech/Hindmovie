package v5;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends Dialog {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f13428v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f13429w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f13430x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f13431y;

    public i(Context context, String str, String str2, String str3, String str4) {
        super(context);
        this.f13428v = str;
        this.f13429w = str2;
        this.f13430x = str3;
        this.f13431y = str4;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(getContext()).inflate(q5.l.dialog_notification, (ViewGroup) null, false);
        int i = q5.k.body_txt;
        TextView textView = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
        if (textView != null) {
            i = q5.k.image;
            ImageView imageView = (ImageView) android.support.v4.media.session.b.l(viewInflate, i);
            if (imageView != null) {
                i = q5.k.open_btn;
                Button button = (Button) android.support.v4.media.session.b.l(viewInflate, i);
                if (button != null) {
                    i = q5.k.title_txt;
                    TextView textView2 = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
                    if (textView2 != null) {
                        setContentView((RelativeLayout) viewInflate);
                        Window window = getWindow();
                        Objects.requireNonNull(window);
                        window.setBackgroundDrawable(new ColorDrawable(0));
                        setCancelable(true);
                        setCanceledOnTouchOutside(true);
                        textView2.setText(this.f13428v);
                        textView.setText(this.f13429w);
                        String str = this.f13430x;
                        if (str == null || !str.startsWith("http")) {
                            imageView.setVisibility(8);
                        } else {
                            com.bumptech.glide.b.d(getContext()).q(str).B(imageView);
                            imageView.setVisibility(0);
                        }
                        String str2 = this.f13431y;
                        if (str2 == null || "no".equals(str2)) {
                            button.setVisibility(8);
                            return;
                        } else {
                            button.setVisibility(0);
                            button.setOnClickListener(new com.google.android.material.datepicker.n(12, this));
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
