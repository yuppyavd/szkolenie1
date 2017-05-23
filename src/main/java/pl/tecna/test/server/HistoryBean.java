package pl.tecna.test.server;

import java.util.Date;

import com.google.inject.ImplementedBy;

import pl.tecna.test.domain.Activity;
import pl.tecna.test.domain.History;

@ImplementedBy(HistoryBeanImpl.class)
public interface HistoryBean {

	History add(Activity activity, Date date);
}
