package v5;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.card.MaterialCardView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends Dialog {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f13440v;

    public o(Context context, String str) {
        super(context);
        this.f13440v = str;
    }

    public static void a(Context context, String str) {
        if (!context.getSharedPreferences("DataPreferences", 0).getBoolean("tg_dialog", true) || context.getSharedPreferences("DataPreferences", 0).getBoolean("is_tv", false)) {
            return;
        }
        o oVar = new o(context, str);
        oVar.setCancelable(true);
        oVar.setCanceledOnTouchOutside(false);
        Window window = oVar.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        oVar.show();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(q5.l.dialog_telegram, (ViewGroup) null, false);
        int i = q5.k.card_view;
        if (((MaterialCardView) android.support.v4.media.session.b.l(viewInflate, i)) != null) {
            i = q5.k.donot_show_btn;
            Button button = (Button) android.support.v4.media.session.b.l(viewInflate, i);
            if (button != null) {
                i = q5.k.join_tg_btn;
                Button button2 = (Button) android.support.v4.media.session.b.l(viewInflate, i);
                if (button2 != null) {
                    i = q5.k.later_btn;
                    Button button3 = (Button) android.support.v4.media.session.b.l(viewInflate, i);
                    if (button3 != null) {
                        setContentView((RelativeLayout) viewInflate);
                        final int i10 = 0;
                        button3.setOnClickListener(new View.OnClickListener(this) { // from class: v5.n

                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                            public final /* synthetic */ o f13439w;

                            {
                                this.f13439w = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i10) {
                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                        this.f13439w.dismiss();
                                        break;
                                    case 1:
                                        o oVar = this.f13439w;
                                        oVar.getClass();
                                        try {
                                            Intent intent = new Intent("android.intent.action.VIEW");
                                            intent.setData(Uri.parse(oVar.f13440v));
                                            oVar.getContext().startActivity(intent);
                                            oVar.dismiss();
                                        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
                                            Toast.makeText(oVar.getContext(), "Telegram not installed", 0).show();
                                            return;
                                        }
                                        break;
                                    default:
                                        o oVar2 = this.f13439w;
                                        com.bumptech.glide.d.u(oVar2.getContext()).putBoolean("tg_dialog", false).apply();
                                        oVar2.dismiss();
                                        break;
                                }
                            }
                        });
                        final int i11 = 1;
                        button2.setOnClickListener(new View.OnClickListener(this) { // from class: v5.n

                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                            public final /* synthetic */ o f13439w;

                            {
                                this.f13439w = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i11) {
                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                        this.f13439w.dismiss();
                                        break;
                                    case 1:
                                        o oVar = this.f13439w;
                                        oVar.getClass();
                                        try {
                                            Intent intent = new Intent("android.intent.action.VIEW");
                                            intent.setData(Uri.parse(oVar.f13440v));
                                            oVar.getContext().startActivity(intent);
                                            oVar.dismiss();
                                        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
                                            Toast.makeText(oVar.getContext(), "Telegram not installed", 0).show();
                                            return;
                                        }
                                        break;
                                    default:
                                        o oVar2 = this.f13439w;
                                        com.bumptech.glide.d.u(oVar2.getContext()).putBoolean("tg_dialog", false).apply();
                                        oVar2.dismiss();
                                        break;
                                }
                            }
                        });
                        final int i12 = 2;
                        button.setOnClickListener(new View.OnClickListener(this) { // from class: v5.n

                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                            public final /* synthetic */ o f13439w;

                            {
                                this.f13439w = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i12) {
                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                        this.f13439w.dismiss();
                                        break;
                                    case 1:
                                        o oVar = this.f13439w;
                                        oVar.getClass();
                                        try {
                                            Intent intent = new Intent("android.intent.action.VIEW");
                                            intent.setData(Uri.parse(oVar.f13440v));
                                            oVar.getContext().startActivity(intent);
                                            oVar.dismiss();
                                        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
                                            Toast.makeText(oVar.getContext(), "Telegram not installed", 0).show();
                                            return;
                                        }
                                        break;
                                    default:
                                        o oVar2 = this.f13439w;
                                        com.bumptech.glide.d.u(oVar2.getContext()).putBoolean("tg_dialog", false).apply();
                                        oVar2.dismiss();
                                        break;
                                }
                            }
                        });
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
