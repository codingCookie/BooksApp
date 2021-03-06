/*
 * Copyright 2011 Jonas Bengtsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wigwamlabs.booksapp.db;

import java.util.List;

import com.wigwamlabs.booksapp.db.DatabaseAdapter.CursorType;

public class AuthorActions {
	private static final ManyToManyActions ACTIONS = new ManyToManyActions(AuthorsTable.n,
			AuthorsTable._id, AuthorsTable.name, AuthorsTable.name_normalized, true,
			AuthorsTable.book_count, BookAuthorsTable.n, BookAuthorsTable.book_id,
			BookAuthorsTable.author_id);

	public static void updateAuthors(DatabaseAdapter db, int t, long bookId, List<String> creators,
			boolean checkExistingAuthors) {
		ACTIONS.updateItems(db, t, bookId, creators, checkExistingAuthors, true,
				CursorType.AUTHOR_LIST);
	}
}
